/*
 * Copyright 2018 Doug Valenta.
 * Licensed under the terms of the MIT License.
 */
package io.codecastle.athenaeum.json;

import io.codecastle.athenaeum.Attachment;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 *
 * @author Doug Valenta
 */
public interface JsonObject<A, THIS extends JsonObject<A, THIS>> extends Attachment<A> {
	
	public <B> OnJsonKey<A, THIS, B> onKey(Function<? super String, B> keyFunction);
	public <B> OnJsonKey<A, THIS, B> onKey(BiFunction<A, ? super String, B> keyFunction);
	public OnJsonKey<A, THIS, A> onKey(Consumer<? super String> keyConsumer);
	public OnJsonKey<A, THIS, A> onKey(BiConsumer<A, ? super String> keyConsumer);
	
	public <B> OnJsonKey<A, THIS, B> onKey(CharSequence key, Supplier<B> attachmentSupplier);
	public <B> OnJsonKey<A, THIS, B> onKey(CharSequence key, Function<A, B> attachmentFunction);
	public OnJsonKey<A, THIS, A> onKey(CharSequence key);
	public OnJsonKey<A, THIS, A> onKey(CharSequence key, Runnable runnable);
	public OnJsonKey<A, THIS, A> onKey(CharSequence key, Consumer<A> attachmentConsumer);
	
	public <B> OnJsonKey<A, THIS, B> onAnyKey(Supplier<B> attachmentSupplier);
	public <B> OnJsonKey<A, THIS, B> onAnyKey(Function<A, B> attachmentFunction);
	public OnJsonKey<A, THIS, A> onAnyKey();
	public OnJsonKey<A, THIS, A> onAnyKey(Runnable runnable);
	public OnJsonKey<A, THIS, A> onAnyKey(Consumer<A> attachmentConsumer);
	
}
