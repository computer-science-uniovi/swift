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

public class ClosedRange<T extends Comparable<T>> extends AbstractRange<T> {

	private ClosedRange( Bound<T> min, Bound<T> max ) {
		super( min, max );
	}

	@Override public boolean contains( T element ) {
		return ( min().value().compareTo( element ) == -1
				&& element.compareTo( max().value() ) == -1 );
	}

	public static <K extends Comparable<K>> AbstractRange<K> of( K min, K max ) {
		return new ClosedRange<K>( ClosedBound.of( min ), ClosedBound.of( max ) );
	}
	
	public static <K extends Comparable<K>> AbstractRange<K> of( ClosedBound<K> min, ClosedBound<K> max ) {
		return new ClosedRange<K>( min , max );
	}

	@Override public boolean overlaps( Range<T> other ) {
		throw new IllegalStateException( "Action not implemented yet" );
	}

}
