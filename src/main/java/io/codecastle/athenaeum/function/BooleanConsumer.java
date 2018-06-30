/*
 * Copyright 2018 Doug Valenta.
 * Licensed under the terms of the MIT License.
 */
package io.codecastle.athenaeum.function;

/**
 *
 * @author Doug Valenta
 */
@FunctionalInterface
public interface BooleanConsumer {
	
	public void accept(boolean value);
	
}
