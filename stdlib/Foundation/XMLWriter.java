package Foundation;

import java.io.FileWriter;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

public class XMLWriter {

	public static <T> void _write(ArrayList<T> objects, String root, String documentName) {

		try {

			Element top = new Element(root);
			Document doc = new Document(top);

			for (Object o : objects) {
				Class<?> clazz = o.getClass();

				Element obj = new Element(o.getClass().getSimpleName());

				for (Field field : clazz.getDeclaredFields()) {
					String name = field.getName();
					String value = "";
					for (Method method : clazz.getMethods()) {
						if (method.getName().toLowerCase().endsWith("get" + field.getName().toLowerCase())) {
							try {
								value = String.valueOf(method.invoke(o));
							} catch (IllegalAccessException e) {
								System.out.println("Could not determine method: " + method.getName());
							} catch (InvocationTargetException e) {
								System.out.println("Could not determine method: " + method.getName());
							}
						}
					}
					obj.addContent(new Element(name).setText(value));
				}
				doc.getRootElement().addContent(obj);
			}
			XMLOutputter output = new XMLOutputter();
			output.setFormat(Format.getPrettyFormat());
			output.output(doc, new FileWriter(documentName + ".xml"));
		} catch (Exception e) {
			System.out.println("Something happens");
		}
	}

}
