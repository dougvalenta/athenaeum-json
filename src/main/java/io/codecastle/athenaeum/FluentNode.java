/*
 * Copyright 2018 Doug Valenta.
 * Licensed under the terms of the MIT License.
 */
package io.codecastle.athenaeum;

import java.util.function.Consumer;

/**
 *
 * @author Doug Valenta
 */
public interface FluentNode<P, A> extends Attachment<A> {
	
	public P then();
	
	public P then(Consumer<A> attachmentConsumer);
	
}
