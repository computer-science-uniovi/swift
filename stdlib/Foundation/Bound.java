/*
 * This source file is part of the Swift open source project.
 *
 * Copyright (c) 2017 Guillermo Facundo Colunga and the Swift project authors.
 * Licensed under GNU General Public License v3.0.
 *
 * See /LICENSE for license information.
 * 
 */
package Foundation;

/**
 * Instance of Bound.java
 * 
 * @author
 * @version
 */
public interface Bound<T extends Comparable<T>> extends Comparable<Bound<T>> {

	/**
	 * Returns the value of the bound.
	 * 
	 * @return the value of the bound.
	 */
	public T value();
}
