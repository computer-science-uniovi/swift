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
 * @author guille
 * @version
 * @since 2017"4"522017
 * @formatter Oviedo Computing Community
 * @param <T>
 */
public interface Range<T extends Comparable<T>> {

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
