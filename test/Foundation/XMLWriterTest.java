package Foundation;

import static org.junit.Assert.assertEquals;

import java.awt.Point;
import java.util.ArrayList;

import org.junit.Test;

public class XMLWriterTest {

	@Test
	public void test() {
		String expected = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"
				+"<Points><Point><x>2.0</x><y>3.0</y><serialVersionUID>"
				+"error</serialVersionUID></Point><Point><x>4.0</x><y>3.0"
				+"</y><serialVersionUID>error</serialVersionUID></Point><Point>"
				+"<x>6.0</x><y>9.0</y><serialVersionUID>error</serialVersionUID>"+
				"</Point><Point><x>5.0</x><y>7.0</y><serialVersionUID>error</serialVersionUID>"
				+"</Point><Point><x>1.0</x><y>2.0</y><serialVersionUID>error</serialVersionUID>"
				+"</Point></Points>";
		

		ArrayList<Point> p1 = new ArrayList<Point>();
		p1.add(new Point(2, 3));
		p1.add(new Point(4, 3));
		p1.add(new Point(6, 9));
		p1.add(new Point(5, 7));
		p1.add(new Point(1, 2));

		assertEquals(expected, XMLWriter._writeXML(p1, "Points"));

	}

}
