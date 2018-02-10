/*
 * This source file is part of the swift open source project.
 *
 * Copyright (c) 2018 willy and the swift project authors.
 * Licensed under GNU General Public License v3.0.
 *
 * See /LICENSE for license information.
 * 
 */
package Foundation;

import java.util.Collection;
import java.util.Hashtable;

/**
 * Instance of CSVRecord.java
 * 
 * @author Guillermo Facundo Colunga
 * @version 201802100040
 */
public class CSVRecord {

	private Hashtable<String, String> _record;
	private CSVFile _parent;

	public CSVRecord( CSVFile parent ) {
		_record = new Hashtable<String, String>();
		this._parent = parent;
	}

	/**
	 * Adds a column to the row, the value will be the value of the column on
	 * that row.
	 * 
	 * @param value for he column on the row
	 */
	public void addColumn( String value ) {
		_record.put( _parent.getHeaders()[_record.size()], value );
	}

	/**
	 * Gets the value of the column on the row.
	 * 
	 * @param header to map the column to return.
	 * @return the content as a string.
	 */
	public String getColumn( String header ) {
		return _record.get( header );
	}

	/**
	 * Returns a collection containing all the columns of the row.
	 * 
	 * @return a collection containing all the columns of the row.
	 */
	public Collection<String> getColumns() {
		return _record.values();
	}

	/**
	 * Adds a collection of columns to the existing ones.
	 * 
	 * @param values to add to the row.
	 */
	public void addColumns( String... values ) {
		for (String value : values) {
			_record.put( _parent.getHeaders()[_record.size()], value );
		}
	}

	/**
	 * @return the size of the column.
	 */
	public int size() {
		return _record.size();
	}

}
