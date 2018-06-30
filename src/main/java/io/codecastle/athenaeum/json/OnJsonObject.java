/*
 * Copyright 2018 Doug Valenta.
 * Licensed under the terms of the MIT License.
 */
package io.codecastle.athenaeum.json;

import io.codecastle.athenaeum.Attachment;
import io.codecastle.athenaeum.InnerFluentNode;

/**
 *
 * @author Doug Valenta
 */
public interface OnJsonObject<A0, P extends Attachment<A0>, A> extends JsonObject<A, OnJsonObject<A0, P, A>>, InnerFluentNode<A0, P, A> {
	
}
