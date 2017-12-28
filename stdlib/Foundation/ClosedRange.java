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

import java.util.Optional;

/**
 * Instance of ClosedRange.java
 * 
 * @author
 * @version
 */
public class ClosedRange<T extends Comparable<T>> extends AbstractRange<T> {

	private ClosedRange( Bound<T> min, Bound<T> max ) {
		super( min, max );
	}

	/**
	 * Factory to create a ClosedRange.
	 * 
	 * @param min value of the range.
	 * @param max value of the range.
	 * @return the ClosedRange ready to be use.
	 */
	public static <K extends Comparable<K>> AbstractRange<K> of( K min, K max ) {
		Optional<K> _min = Optional.ofNullable( min ),
				_max = Optional.ofNullable( max );

		return new ClosedRange<K>(
				ClosedBound.of(
						_min.orElseThrow( () -> new IllegalArgumentException(
								"The min value cannot be null." ) ) ),
				ClosedBound.of(
						_max.orElseThrow( () -> new IllegalArgumentException(
								"The max value cannot be null." ) ) ) );
	}

	/**
	 * Factory to create a ClosedRange.
	 * 
	 * @param min value of the range.
	 * @param max value of the range.
	 * @return the ClosedRange ready to be use.
	 */
	public static <K extends Comparable<K>> AbstractRange<K> of( ClosedBound<K> min,
			ClosedBound<K> max ) {
		Optional<ClosedBound<K>> _min = Optional.ofNullable( min ),
				_max = Optional.ofNullable( max );

		return new ClosedRange<K>(
				_min.orElseThrow( () -> new IllegalArgumentException(
						"The min value cannot be null." ) ),
				_max.orElseThrow( () -> new IllegalArgumentException(
						"The max value cannot be null." ) ) );
	}

	@Override public boolean contains( T element ) {
		Optional<T> _element = Optional.ofNullable( element );
		// Check if the element is null.
		_element.orElseThrow(
				() -> new IllegalArgumentException( "The element to check cannot be null." ) );

		return ( min().value().compareTo( _element.get() ) == -1
				&& _element.get().compareTo( max().value() ) == -1 );
	}

	@Override public boolean overlaps( Range<T> other ) {
		throw new IllegalStateException( "Action not implemented yet" );
	}

}
