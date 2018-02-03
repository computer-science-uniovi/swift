package Foundation;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CSVFileTest {

    private CSVFile file;

    @Before
    public void setUp() {
	file = new CSVFile(new URL("noname.csv"));
    }

    @After
    public void tearDown() {
	try {

	    File file = new File("noname.csv");

	    if (file.delete()) {
		System.out.println(file.getName() + " is deleted!");
	    } else {
		System.out.println("Delete operation is failed.");
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	}
    }

    @Test
    public void test() {
	String[] data = { "first", "second", "third" };
	String[] data2 = { "ss", "aa", "22" };
	file.getContent().put("1", data);
	file.getContent().put("2", data2);
	file.setSeparator(",");
	file.save();

	file = CSVFile.of(new URL("noname.csv"), ",");
	assertArrayEquals(data, file.getContent().get("1"));
    }

}
