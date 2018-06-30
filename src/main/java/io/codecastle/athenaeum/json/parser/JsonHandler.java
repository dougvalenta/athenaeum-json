/*
 * Copyright 2018 Doug Valenta.
 * Licensed under the terms of the MIT License.
 */
package io.codecastle.athenaeum.json.parser;

/**
 *
 * @author Doug Valenta
 */
public interface JsonHandler {
	
	public void onBeginObject();
	
	public void onEndObject();
	
	public void onBeginArray();
	
	public void onEndArray();
	
	public void onKey(String key);
	
	public void onNullValue();
	
	public void onBooleanValue(boolean value);
	
	public void onFloatingPointValue(String value);
	
	public void onIntegralValue(String value);
	
	public void onStringValue(String value);
	
}
