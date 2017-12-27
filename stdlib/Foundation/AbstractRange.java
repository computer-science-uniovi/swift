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

	private Bound<T> min, max;

	protected AbstractRange( Bound<T> min, Bound<T> max ) {
		if (min == null || max == null || min.compareTo( max ) > -1) {
			throw new IllegalArgumentException( "Check arguments parameters:"
					+ " min = " + min
					+ " max = " + max );
		}
		this.min = min;
		this.max = max;
	}
	
	public Bound<T> min() { return this.min; }
	
	public Bound<T> max() { return this.max; }

}
