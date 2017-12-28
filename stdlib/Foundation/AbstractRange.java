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

/**
 * Instance of AbstractRange.java
 * 
 * @author
 * @version
 */
public abstract class AbstractRange<T extends Comparable<T>> implements Range<T> {

	private Bound<T> _min, _max;

	protected AbstractRange( Bound<T> min, Bound<T> max ) {
		if (min == null || max == null || min.compareTo( max ) > -1) {
			throw new IllegalArgumentException( "Check arguments parameters:"
					+ " min = " + min
					+ " max = " + max );
		}
		this._min = min;
		this._max = max;
	}

	@Override public Bound<T> min() {
		return this._min;
	}

	@Override public Bound<T> max() {
		return this._max;
	}

	@Override public String toString() {
		return "[" + _min.value() + "..." + _max.value() + "]";
	}

}
