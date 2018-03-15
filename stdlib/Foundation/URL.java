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
 * 
 * A value that identifies the location of a resource, such as an item on a
 * remote server or the path to a local file.
 * 
 * @author Guillermo Facundo Colunga
 * @version 201802032056
 */
public class URL {

	private String _fileURLWithPath = "";
	private String _user, _password;
	private int _port;

	public URL( String fileURLWithPath ) {
		this._fileURLWithPath = fileURLWithPath;
	}

	public String getFileURL() {
		return this._fileURLWithPath;
	}

	public String getUser() {
		return this._user;
	}

	public void setUser( String user ) {
		_user = user;
	}

	public String getPassword() {
		return this._password;
	}

	public void setPassword( String password ) {
		_password = password;
	}

	public int getPort() {
		return _port;
	}

	public void setPort( int port ) {
		_port = port;
	}
}
