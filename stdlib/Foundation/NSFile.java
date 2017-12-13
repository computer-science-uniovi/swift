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

import java.io.File;

/**
 * Instance of NSFile.
 * 
 * @author Guillermo Facundo Colunga
 */
public class NSFile extends File {

	private static final long serialVersionUID = 2908707080448348423L;

	private String _path, _fileName;

	/**
	 * Creates an instance of NSFile from a path and a filename;
	 * 
	 * @param path The path to the file directory.
	 * @param fileName The filename with the extension.
	 */
	public NSFile( String path, String fileName ) {
		super( path + "/" + fileName );
		this._path = path;
		this._fileName = fileName;
	}

	/**
	 * @return The path to the file directory.
	 */
	public String path() {
		return this._path;
	}

	/**
	 * @return The filename and the extension.
	 */
	public String name() {
		return this._fileName;
	}

	/**
	 * @return The complete path and the filename.
	 */
	public String completePath() {
		return _path + "/" + _fileName;
	}

}
