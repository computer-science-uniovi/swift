package Foundation;

import java.util.Collection;
import java.util.Map;

public class Util {

	public static boolean isClassCollection(Class<?> c) {
		return Collection.class.isAssignableFrom(c) || Map.class.isAssignableFrom(c);
	}

	public static boolean isCollection(Object ob) {
		return ob instanceof Collection || ob instanceof Map;
	}
}
