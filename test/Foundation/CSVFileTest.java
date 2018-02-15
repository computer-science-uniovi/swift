package Foundation;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CSVFileTest {
	private CSVFile file;

	@Before public void setUp() {
		String[] headers = {"id","kind"};
		file = new CSVFile( new URL( "noname.csv" ), headers);
	}

	@After public void tearDown() {
		try {

			File file = new File( "noname.csv" );

			if (file.delete()) {
				System.out.println( file.getName() + " is deleted!" );
			} else {
				System.out.println( "Delete operation is failed." );
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test public void test() {
		file.setHeaders( "id", "name", "suname1", "surname2" );
		file.addRow( "1", "pepe", "gutiezed", "calvo" );
		file.addRow( "2", "carlos", "lala", "lolo" );
		file.setSeparator( "," );
		file.save();

		file = CSVFile.of( new URL( "noname.csv" ), ",", "id", "name", "suname1", "surname2" );
		assertEquals( "pepe", file.getRowAt( 0 ).getColumn( "name" ) );
	}

}
