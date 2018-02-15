package Foundation;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

public class XMLWriter {

	public static <T> void _write(ArrayList<T> objects, String root, String documentName) {
		FileWriter fichero = null;
		PrintWriter pw = null;
		try {
			fichero = new FileWriter(documentName + ".xml");
			pw = new PrintWriter(fichero);

			pw.write(getHeadborard());
			pw.write(lineBreak());
			pw.write(openElement(root));

			pw.write(lineBreak());
			pw.write(tab());

			for (Object o : objects) {
				Class<?> clazz = o.getClass();
				String objectName = o.getClass().getSimpleName();
				pw.write(openElement(objectName));
				pw.write(lineBreak());

				for (Field field : clazz.getDeclaredFields()) {
					String fieldName = field.getName();
					// System.out.println(Util.isCollection(field.getType()));
					// System.out.println(Util.isClassCollection(field.getType()));
					// System.out.println();
					// if (field.getType().getSuperclass() instanceof Collection) {
					// type new_name = (type) value;
					//
					// }
					pw.write(tab());
					pw.write(tab());
					pw.write(openElement(fieldName));
					pw.write(getValue(field, clazz, o));
					pw.write(closeElement(fieldName));
					pw.write(lineBreak());
				}
				pw.write(tab());
				pw.write(closeElement(objectName));
				pw.write(lineBreak());
				pw.write(tab());
			}
			pw.write(lineBreak());
			pw.write(closeElement(root));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				// Nuevamente aprovechamos el finally para
				// asegurarnos que se cierra el fichero.
				if (null != fichero)
					fichero.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	private static String getValue(Field field, Class<?> clazz, Object o) {
		String fieldName = field.getName();
		for (Method method : clazz.getMethods()) {
			if (method.getName().toLowerCase().endsWith("get" + fieldName.toLowerCase())) {
				try {
					return String.valueOf(method.invoke(o));
				} catch (IllegalAccessException e) {
					System.out.println("Could not determine method: " + method.getName());
				} catch (InvocationTargetException e) {
					System.out.println("Could not determine method: " + method.getName());
				}
			}
		}
		return "error";
	}

	public static boolean isClassCollection(Class<?> c) {
		return Collection.class.isAssignableFrom(c) || Map.class.isAssignableFrom(c) || c.isArray();
	}

	private static String openElement(String element) {
		return "<" + element + ">";
	}

	private static String closeElement(String element) {
		return "</" + element + ">";
	}

	private static String getHeadborard() {
		return "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
	}

	private static String lineBreak() {
		return "\n";
	}

	private static String tab() {
		return "\t";
	}

	public static <T> void test(ArrayList<T> objects, String root, String documentName) {
		try {

			Element top = new Element(root);
			Document doc = new Document(top);

			for (Object o : objects) {
				Class<?> clazz = o.getClass();

				Element obj = new Element(o.getClass().getSimpleName());

				for (Field field : clazz.getDeclaredFields()) {
					String name = field.getName();
					String value = "";
					System.out.println(isClassCollection(field.getType()));
					System.out.println();
					// if (field.getType().getSuperclass() instanceof Collection) {
					// type new_name = (type) value;
					//
					// }
					for (Method method : clazz.getMethods()) {
						if (method.getName().toLowerCase().endsWith("get" + name.toLowerCase())) {
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
