/*
 * Copyright 2018 Doug Valenta.
 * Licensed under the terms of the MIT License.
 */
package io.codecastle.athenaeum.json;

import io.codecastle.athenaeum.Attachment;
import io.codecastle.athenaeum.InnerFluentNode;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 *
 * @author Doug Valenta
 */
public interface OnJsonKey<A0, P extends Attachment<A0>, A> extends InnerFluentNode<A0, P, A> { 
	
	public P pass();
	
	public OnJsonKey<A0, P, A> onNull(Runnable runnable);
	public OnJsonKey<A0, P, A> onNull(Consumer<A> attachmentConsumer);
	
	public OnJsonKey<A0, P, A> onBoolean(Consumer<Boolean> valueConsumer);
	public OnJsonKey<A0, P, A> onBoolean(BiConsumer<A, Boolean> valueConsumer);
	
	public OnJsonKey<A0, P, A> onBoolean(boolean value, Runnable runnable);
	public OnJsonKey<A0, P, A> onBoolean(boolean value, Consumer<A> attachmentConsumer);
	
	public OnJsonKey<A0, P, A> onAnyBoolean(Runnable runnable);
	public OnJsonKey<A0, P, A> onAnyBoolean(Consumer<A> attachmentConsumer);
	
	public OnJsonKey<A0, P, A> onNumber(Consumer<? super BigDecimal> valueConsumer);
	public OnJsonKey<A0, P, A> onNumber(BiConsumer<? super A, ? super BigDecimal> valueConsumer);
	
	public OnJsonKey<A0, P, A> onNumber(BigDecimal value, Runnable runnable);
	public OnJsonKey<A0, P, A> onNumber(BigInteger value, Runnable runnable);
	public OnJsonKey<A0, P, A> onNumber(Double value, Runnable runnable);
	public OnJsonKey<A0, P, A> onNumber(Long value, Runnable runnable);
	public OnJsonKey<A0, P, A> onNumber(Float value, Runnable runnable);
	public OnJsonKey<A0, P, A> onNumber(Integer value, Runnable runnable);
	public OnJsonKey<A0, P, A> onNumber(double value, Runnable runnable);
	public OnJsonKey<A0, P, A> onNumber(long value, Runnable runnable);
	public OnJsonKey<A0, P, A> onNumber(float value, Runnable runnable);
	public OnJsonKey<A0, P, A> onNumber(int value, Runnable runnable);
	public OnJsonKey<A0, P, A> onNumber(short value, Runnable runnable);
	public OnJsonKey<A0, P, A> onNumber(byte value, Runnable runnable);
	
	public OnJsonKey<A0, P, A> onNumber(BigDecimal value, Consumer<? super A> attachmentConsumer);
	public OnJsonKey<A0, P, A> onNumber(BigInteger value, Consumer<? super A> attachmentConsumer);
	public OnJsonKey<A0, P, A> onNumber(Double value, Consumer<? super A> attachmentConsumer);
	public OnJsonKey<A0, P, A> onNumber(Long value, Consumer<? super A> attachmentConsumer);
	public OnJsonKey<A0, P, A> onNumber(Float value, Consumer<? super A> attachmentConsumer);
	public OnJsonKey<A0, P, A> onNumber(Integer value, Consumer<? super A> attachmentConsumer);
	public OnJsonKey<A0, P, A> onNumber(double value, Consumer<? super A> attachmentConsumer);
	public OnJsonKey<A0, P, A> onNumber(long value, Consumer<? super A> attachmentConsumer);
	public OnJsonKey<A0, P, A> onNumber(float value, Consumer<? super A> attachmentConsumer);
	public OnJsonKey<A0, P, A> onNumber(int value, Consumer<? super A> attachmentConsumer);
	public OnJsonKey<A0, P, A> onNumber(short value, Consumer<? super A> attachmentConsumer);
	public OnJsonKey<A0, P, A> onNumber(byte value, Consumer<? super A> attachmentConsumer);
	
	public OnJsonKey<A0, P, A> onFloatingPointNumber(Consumer<? super BigDecimal> valueConsumer);
	public OnJsonKey<A0, P, A> onFloatingPointNumber(BiConsumer<? super A, ? super BigDecimal> valueConsumer);
	
	public OnJsonKey<A0, P, A> onIntegralNumber(Consumer<? super BigInteger> valueConsumer);
	public OnJsonKey<A0, P, A> onIntegralNumber(BiConsumer<? super A, ? super BigInteger> valueConsumer);
	
	public OnJsonKey<A0, P, A> onDouble(Consumer<Double> valueConsumer);
	public OnJsonKey<A0, P, A> onDouble(BiConsumer<? super A, Double> valueConsumer);

	public OnJsonKey<A0, P, A> onFloat(Consumer<Float> valueConsumer);
	public OnJsonKey<A0, P, A> onFloat(BiConsumer<? super A, Float> valueConsumer);
	
	public OnJsonKey<A0, P, A> onLong(Consumer<Long> valueConsumer);
	public OnJsonKey<A0, P, A> onLong(BiConsumer<? super A, Long> valueConsumer);
	
	public OnJsonKey<A0, P, A> onInteger(Consumer<Integer> valueConsumer);
	public OnJsonKey<A0, P, A> onInteger(BiConsumer<? super A, Integer> valueConsumer);
	
	public OnJsonKey<A0, P, A> onAnyNumber(Runnable runnable);
	public OnJsonKey<A0, P, A> onAnyNumber(Consumer<A> attachmentConsumer);
	
	public OnJsonKey<A0, P, A> onString(Consumer<? super String> valueConsumer);
	public OnJsonKey<A0, P, A> onString(BiConsumer<? super A, ? super String> valueConsumer);
	
	public OnJsonKey<A0, P, A> onCharacter(Consumer<Character> valueConsumer);
	public OnJsonKey<A0, P, A> onCharacter(BiConsumer<? super A, Character> valueConsumer);
	
	public OnJsonKey<A0, P, A> onString(String value, Runnable runnable);
	public OnJsonKey<A0, P, A> onString(CharSequence value, Runnable runnable);
	public OnJsonKey<A0, P, A> onString(Character value, Runnable runnable);
	public OnJsonKey<A0, P, A> onString(char value, Runnable runnable);
	
	public OnJsonKey<A0, P, A> onString(String value, Consumer<? super A> attachmentConsumer);
	public OnJsonKey<A0, P, A> onString(CharSequence value, Consumer<? super A> attachmentConsumer);
	public OnJsonKey<A0, P, A> onString(Character value, Consumer<? super A> attachmentConsumer);
	public OnJsonKey<A0, P, A> onString(char value, Consumer<? super A> attachmentConsumer);
	
	public OnJsonKey<A0, P, A> onAnyString(Runnable runnable);
	public OnJsonKey<A0, P, A> onAnyString(Consumer<? super A> attachmentConsumer);
	
	public OnJsonObject<A, OnJsonKey<A0, P, A>, A> onObject();
	public OnJsonObject<A, OnJsonKey<A0, P, A>, A> onObject(Runnable runnable);
	public OnJsonObject<A, OnJsonKey<A0, P, A>, A> onObject(Consumer<A> attachmentConsumer);
	public <B> OnJsonObject<A, OnJsonKey<A0, P, A>, B> onObject(Supplier<B> attachmentSupplier);
	public <B> OnJsonObject<A, OnJsonKey<A0, P, A>, B> onObject(Function<A, B> attachmentFunction);
	
}
