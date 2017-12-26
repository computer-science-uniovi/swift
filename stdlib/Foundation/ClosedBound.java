/*
 * This source file is part of the Swift open source project.
 *
 * Copyright (c) 2017 Guillermo Facundo Colunga and the Swift project authors.
 * Licensed under GNU General Public License v3.0.
 *
 * See /LICENSE for license information.
 * 
 */
package Foundation;

public class ClosedBound<T extends Comparable<T>> implements Bound<T> {
	
	private T value;
	
	private ClosedBound(T value) {
		this.value = value;
	}
	
	public static <K extends Comparable<K>> Bound<K> of(K value) {
		return new ClosedBound<K>( value );
	}

	@Override public int compareTo( Bound<T> other ) {
		return value.compareTo( other.value() );
	}

	@Override public T value() {
		return this.value;
	}
}
