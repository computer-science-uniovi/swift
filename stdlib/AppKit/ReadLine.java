/*
 * This source file is part of the swift open source project.
 *
 * Copyright (c) 2017 willy and the swift project authors.
 * Licensed under GNU General Public License v3.0.
 *
 * See /LICENSE for license information.
 * 
 */
package AppKit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Instance of ReadLine
 * 
 * @author Guillermo Facundo Colunga
 * @version 1
 */
public interface ReadLine {
	
	static BufferedReader kbd = new BufferedReader(
			new InputStreamReader(System.in));
	
	default String readLine() {
		try {
			return kbd.readLine();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

}
