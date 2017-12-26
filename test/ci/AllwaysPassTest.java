package ci;

import static org.junit.Assert.*;

import org.junit.Test;

public class AllwaysPassTest {

	@Test public void test() {
		assertEquals( true, true );
		System.out.println( "Test passed!" );
		// fail();
	}

}
