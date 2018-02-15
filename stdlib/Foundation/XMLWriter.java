package Foundation;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class XMLWriter {

	/**
	 * Write an XML based on the objects received. You have to specify the root name
	 * of the document and it´s name.
	 * 
	 * @param objects
	 *            the List objects received
	 * @param root
	 *            the root of the document
	 */
	public <T> String save(List<T> objects, String root) {
		String xml = getHeadborard();
		xml += openElement(root);
		for (Object o : objects) {
			Class<?> clazz = o.getClass();
			String objectName = o.getClass().getSimpleName();
			xml += openElement(objectName);

			for (Field field : clazz.getDeclaredFields()) {
				String fieldName = field.getName();
				xml += openElement(fieldName);
				xml += getValue(field, clazz, o);
				xml += closeElement(fieldName);
			}
			xml += closeElement(objectName);
		}
		xml += closeElement(root);
		return xml;
	}

	/**
	 * Returns the value of a generic attribute. You need to specify the class where
	 * the attribute is located to search the correct method that returns it´s
	 * value. The object is needed too because you have to invoke that method with
	 * it.
	 * 
	 * @param field
	 *            the
	 * @param clazz
	 * @param o
	 * @return
	 */
	private String getValue(Field field, Class<?> clazz, Object o) {
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

	/**
	 * Returns true if the Class that receives inherit from Collection
	 * 
	 * @param c
	 * @return
	 */
	public boolean isClassCollection(Class<?> c) {
		return Collection.class.isAssignableFrom(c) || Map.class.isAssignableFrom(c) || c.isArray();
	}

	private String openElement(String element) {
		return "<" + element + ">";
	}

	private String closeElement(String element) {
		return "</" + element + ">";
	}

	private String getHeadborard() {
		return "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
	}

}
