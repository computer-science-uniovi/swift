package Foundation;

import java.util.ArrayList;

import entities.Nota;
import entities.Person;

public class Main {

	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {
		ArrayList<Object> objs = new ArrayList<Object>();
		objs.add(new Person("Paco", "SL8R", 18));
		objs.add(new Nota("Comprar pan", "Comprar pan porque si no no hay"));

		ArrayList<Person> obj = new ArrayList<Person>();
		obj.add(new Person("Paco", "SL8R", 18));
		obj.add(new Person("Pepe", "SL8R", 18));
		obj.add(new Person("M", "SL8R", 18));
		obj.add(new Person("Rosendo", "SL8R", 18));
		obj.add(new Person("Kelly", "SL8R", 18));
		obj.add(new Person("Albus", "SL8R", 18));
		obj.add(new Person("Bulfric", "SL8R", 18));
		obj.add(new Person("Percibal", "SL8R", 18));

		XMLWriter._write(obj, "Personas", "XMLPersonas");
		XMLWriter._write(objs, "Objetos", "XMLObjetos");

		System.out.println("Éxito en la operación");
	}

}
