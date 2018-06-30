/*
 * Copyright 2018 Doug Valenta.
 * Licensed under the terms of the MIT License.
 */
package io.codecastle.athenaeum;

import java.util.function.BiConsumer;

/**
 *
 * @author Doug Valenta
 */
public interface InnerFluentNode<A0, P extends Attachment<A0>, A> extends FluentNode<P, A> {
	
	public P then(BiConsumer<A0, A> attachmentConsumer);
	
}
