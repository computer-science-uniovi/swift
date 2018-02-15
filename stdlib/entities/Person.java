package entities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Person {

	private String name;
	private String surname;
	private int age;

	private String[] hijos = new String[] { "Fegnando", "Triniti", "Neo" };
	private ArrayList<String> hijosA = new ArrayList<String>();
	private List<String> hijosL = new ArrayList<String>();

	public Person(String name, String surname, int age) {
		super();
		this.name = name;
		this.surname = surname;
		this.age = age;

		hijosA.add("Fer");
		hijosA.add("Neo");
		hijosA.add("Feo");

		hijosL.add("Fer");
		hijosL.add("Neo");
		hijosL.add("Feo");
	}

	public Person(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * @return the hijos
	 */
	public String[] getHijos() {
		return hijos;
	}

	/**
	 * @param hijos
	 *            the hijos to set
	 */
	public void setHijos(String[] hijos) {
		this.hijos = hijos;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Person [name=" + name + ", surname=" + surname + ", age=" + age + ", hijos=" + Arrays.toString(hijos)
				+ "]";
	}

}
