/*
 * This source file is part of the swift open source project.
 *
 * Copyright (c) 2017 Guillermo Facundo Colunga and the swift project authors.
 * Licensed under GNU General Public License v3.0.
 *
 * See /LICENSE for license information.
 * 
 */
package Foundation;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

import Foundation.ClosedRange;
import Foundation.Range;

/**
 * Instance of RangeTest.java
 * 
 * @author 
 * @version 
 */
public class RangeTest {

	@Test public void closedIntegerRangeTest() {
		
		// ClosedRange 1...3 must contain  2 but not 1, 3, 0, 4 nor -2.
		Range<Integer> intRange = ClosedRange.of( 1, 3 );
		
		// Outside the range.
		assertEquals( false, intRange.contains( -2 ) );
		assertEquals( false, intRange.contains( 0 ) );
		assertEquals( false, intRange.contains( 1 ) );
		
		// Entering the range.
		assertEquals( true, intRange.contains( 2 ) );
		
		// Exiting the range.
		assertEquals( false, intRange.contains( 3 ) );
		assertEquals( false, intRange.contains( 4 ) );
	}
	
	@Test public void closedDoubleRangeTest() {
		
		// ClosedRange -1,0...3,0 must contain  2.0, 0.0, 1.1  but not 3.0, -1.0.
		Range<Double> doubleRange = ClosedRange.of( -1.0, 3.0 );
		
		// Outside the range.
		assertEquals( false, doubleRange.contains( -1.1 ) );
		assertEquals( false, doubleRange.contains( -1.0 ) );
		
		// Entering the range.
		assertEquals( true, doubleRange.contains( 1.0 ) );
		assertEquals( true, doubleRange.contains( 0.0 ) );
		assertEquals( true, doubleRange.contains( 2.0 ) );
		
		// Exiting the range.
		assertEquals( false, doubleRange.contains( 3.0 ) );
		assertEquals( false, doubleRange.contains( 3.1 ) );
	}
	
	@SuppressWarnings("deprecation") @Test public void closedDateTest() {
		
		// Closed range from 01-01-2017...01-01-2018
		Range<Date> calRange = ClosedRange.of( new Date( 2017, 01, 01 ), new Date( 2018, 01, 01 ) );
		
		// Outside the range.
		assertEquals( false, calRange.contains( new Date(2016, 06, 15) ) );
		
		// In the range.
		assertEquals( true, calRange.contains( new Date(2017, 06, 15) ) );
		
		// Outside the range.
		assertEquals( false, calRange.contains( new Date(2018, 06, 15) ) );
	}

}