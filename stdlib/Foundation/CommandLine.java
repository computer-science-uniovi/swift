/*
 * This source file is part of the swift open source project.
 *
 * Copyright (c) 2017 Guillermo Facundo Colunga and the swift project authors.
 * Licensed under GNU General Public License v3.0.
 *
 * See /LICENSE for license information.
 * 
 */
package Foundation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public final class CommandLine {
	
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

	/**
	 * Returns a string read from standard input through the end of the current
	 * line or until EOF is reached.
	 * 
	 * @return The string of characters read from standard input. If EOF has
	 *         already been reached when readLine() is called, the result is
	 *         null.
	 */
	public static String readLine() {
		BufferedReader kbd = new BufferedReader( new InputStreamReader( System.in ) );
		try {
			return kbd.readLine();
		} catch (IOException e) {
			throw new RuntimeException( e );
		}
	}

}
