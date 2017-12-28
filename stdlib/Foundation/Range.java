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
 * A half-open interval over a comparable type, from a lower bound up to, but
 * not including, an upper bound.
 *
 * @author Guillermo Facundo Colunga
 * @param <T> the main type of the range.
 */
public interface Range<T extends Comparable<T>> {

	/**
	 * @return the minimum value of the range. Depending if its an open range or
	 *         a closed range this value will or will not be inside the range
	 *         itself.
	 */
	public Bound<T> min();

	/**
	 * @return the maximum value of the rage. Depending if its an open range or
	 *         a closed range this value will or will not be inside the range
	 *         itself.
	 */
	public Bound<T> max();

	/**
	 * Returns a Boolean value indicating whether the given element is contained
	 * within the range.
	 * 
	 * @param element The element to check for containment.
	 * @return true if element is contained in the range; otherwise, false.
	 */
	public boolean contains( T element );

	/**
	 * Returns a Boolean value indicating whether this range and the given range
	 * contain an element in common.
	 * 
	 * @param other A range to check for elements in common.
	 * @return true if this range and other have at least one element in common;
	 *         otherwise, false.
	 */
	public boolean overlaps( Range<T> other );
}
