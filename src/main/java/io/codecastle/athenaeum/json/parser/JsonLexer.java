/*
 * Copyright 2018 Doug Valenta.
 * Licensed under the terms of the MIT License.
 */
package io.codecastle.athenaeum.json.parser;

import java.io.IOException;
import java.io.Reader;

/**
 *
 * @author Doug Valenta
 */
public class JsonLexer {
	
	private final StringBuilder builder = new StringBuilder();
	private final char[] hexDigits = new char[4];
	private int data;
	
	public void lex(final Reader reader, final JsonHandler handler) throws IOException {
		while ((data = reader.read()) > -1) {
			final char character = (char) data;
			if (character == '{') {
				handler.onBeginObject();
				lexObject(reader, handler);
			}
		}
	}
	
	private void lexObject(final Reader reader, final JsonHandler handler) throws IOException {
		int state = 0;
		while ((data = reader.read()) > -1) {
			if (state == 0) {
				switch (data) {
					case '}':
						handler.onEndObject();
						return;
					case '"':
						handler.onKey(readString(reader));
						state = 1;
						continue;
					default:
						continue;
				}
			} else if (state == 1) {
				if (data == ':') {
					state = 2;
					continue;
				}
			} else if (state == 2) {
				switch (data) {
					case '{':
						handler.onBeginObject();
						lexObject(reader, handler);
						state = 3;
						break;
					case '[':
						handler.onBeginArray();
						lexArray(reader, handler);
						state = 3;
						break;
					case '"':
						handler.onStringValue(readString(reader));
						state = 3;
						break;
					case 't':
						handler.onBooleanValue(true);
						reader.read();
						reader.read();
						reader.read();
						state = 3;
						break;
					case 'f':
						handler.onBooleanValue(false);
						reader.read();
						reader.read();
						reader.read();
						reader.read();
						state = 3;
						break;
					case 'n':
						handler.onNullValue();
						reader.read();
						reader.read();
						reader.read();
						state = 3;
						break;
					default:
						if (data == '-' || (data >= '0' && data <= '9')) {
							lexNumber(reader, handler);
							if (data == '}') {
								handler.onEndObject();
								return;
							} else if (data != ',') {
								state = 3;
							} else {
								state = 0;
							}
							continue;
						}
				}
			} else if (state == 3) {
				switch (data) {
					case '}':
						handler.onEndObject();
						return;
					case ',':
						state = 0;
						continue;
				}
			}
		}
	}
	
	private void lexArray(final Reader reader, final JsonHandler handler) throws IOException {
		boolean comma = false;
		while ((data = reader.read()) > -1) {
			if (!comma) {
				switch (data) {
					case ']':
						handler.onEndArray();
						return;
					case '{':
						handler.onBeginObject();
						lexObject(reader, handler);
						comma = true;
						break;
					case '[':
						handler.onBeginArray();
						lexArray(reader, handler);
						comma = true;
						break;
					case '"':
						handler.onStringValue(readString(reader));
						comma = true;
						break;
					case 't':
						handler.onBooleanValue(true);
						reader.read();
						reader.read();
						reader.read();
						comma = true;
						break;
					case 'f':
						handler.onBooleanValue(false);
						reader.read();
						reader.read();
						reader.read();
						reader.read();
						comma = true;
						break;
					case 'n':
						handler.onNullValue();
						reader.read();
						reader.read();
						reader.read();
						comma = true;
						break;
					default:
						if (data == '-' || (data >= '0' && data <= '9')) {
							lexNumber(reader, handler);
							if (data == ']') {
								handler.onEndArray();
								return;
							} else if (data != ',') {
								comma = true;
							}
							continue;
						}
				}
			} else {
				switch (data) {
					case ']':
						handler.onEndArray();
						return;
					case ',':
						comma = false;
						break;
				}
			}
		}
		
	}
	
	private void lexNumber(final Reader reader, final JsonHandler handler) throws IOException {
		builder.setLength(0);
		builder.append((char) data);
		boolean floatingPoint = false;
		while ((data = reader.read()) > -1) {
			if (data >= '0' || data <= '9') {
				builder.append((char) data);
			} else if (data == '.' || data == 'e' || data == 'E' || data == '-') {
				builder.append((char) data);
				floatingPoint = true;
			} else {
				break;
			}
		}
		if (floatingPoint) {
			handler.onFloatingPointValue(builder.toString());
		} else {
			handler.onIntegralValue(builder.toString());
		}
	}
	
	private String readString(final Reader reader) throws IOException {
		builder.setLength(0);
		while ((data = reader.read()) > -1) {
			switch (data) {
				case '"':
					return builder.toString();
				case '\\':
					if ((data = reader.read()) > -1) {
						switch (data) {
							case 'b':
								builder.append('\b');
								continue;
							case 'f':
								builder.append('\f');
								continue;
							case 'n':
								builder.append('\n');
								continue;
							case 'r':
								builder.append('\r');
								continue;
							case 't':
								builder.append('\t');
								continue;
							case 'u':
								reader.read(hexDigits);
								builder.append((char) Integer.parseInt(new String(hexDigits)));
								continue;
							default:
								builder.append((char) data);
								continue;
						}
					}
			}
		}
		return builder.toString();
	}
	
}
