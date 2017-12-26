package ci;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

import Foundation.ClosedRange;
import Foundation.Range;

public class RangeTest {

	@SuppressWarnings("deprecation") @Test public void test() {
		Range<Integer> intRange = ClosedRange.of( 1, 3 );
		assertEquals( true, intRange.contains( 2 ) );
		assertEquals( false, intRange.contains( 0 ) );
		assertEquals( false, intRange.contains( 1 ) );
		assertEquals( false, intRange.contains( 3 ) );
		assertEquals( false, intRange.contains( -2 ) );
		
		Range<Double> doubleRange = ClosedRange.of( -1.0, 3.0 );
		assertEquals( true, doubleRange.contains( 2.0 ) );
		assertEquals( true, doubleRange.contains( 0.0 ) );
		assertEquals( true, doubleRange.contains( 1.0 ) );
		assertEquals( false, doubleRange.contains( 3.0 ) );
		assertEquals( false, doubleRange.contains( -2.0 ) );
		
		Range<Date> calRange = ClosedRange.of( new Date( 2017, 01, 01 ), new Date( 2018, 01, 01 ) );
		assertEquals( true, calRange.contains( new Date(2017, 06, 15) ) );
		assertEquals( false, calRange.contains( new Date(2016, 06, 15) ) );
		assertEquals( false, calRange.contains( new Date(2018, 06, 15) ) );
	}

}
