/*
 * This source file is part of the swift open source project.
 *
 * Copyright (c) 2017 willy and the swift project authors.
 * Licensed under GNU General Public License v3.0.
 *
 * See /LICENSE for license information.
 * 
 */
package Foundation;

import java.io.Serializable;

/**
 * Instance of NSObject.java
 * 
 * @author
 * @version
 */
public class NSObject extends Object implements Serializable {

	private static final long serialVersionUID = 3889488132491094921L;

	/**
	 * Prints a string.  If the argument is <code>null</code> then the string
     * <code>"null"</code> is printed.  Otherwise, the string's characters are
     * converted into bytes according to the platform's default character
     * encoding, and these bytes are written in exactly the manner of the
     * <code>{@link #write(int)}</code> method.
	 * 
	 * @param		text		The <code>String</code> to be printed
	 */
	public static void print( Object object ) {
		System.out.print( object.toString() + "\n" );
	}

	/**
	 * Prints a string.  If the argument is <code>null</code> then the string
     * <code>"null"</code> is printed.  Otherwise, the string's characters are
     * converted into bytes according to the platform's default character
     * encoding, and these bytes are written in exactly the manner of the
     * <code>{@link #write(int)}</code> method.
	 * 
	 * @param		text		The <code>String</code> to be printed
	 * @param		terminator	The terminator symbol. If null "".
	 */
	public static void print( Object object, String terminator ) {
		if(terminator == null)
			terminator = "";
		System.out.print( object.toString() + terminator );
	}

}
