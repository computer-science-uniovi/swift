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

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class CSVFile {

	private URL _urlToFile;
	private String _separator = "", _terminator = "";
	private List<CSVRecord> _rows;
	private String[] _headers;

	/**
	 * Allocates a CSVFile object and initializes it so that it represents. You
	 * have to include at least one header.
	 * 
	 * @param urlToFile is the path to file + file name + extension.
	 * @param headers of the csv file.
	 */
	public CSVFile( URL urlToFile, String... headers ) {
		this._urlToFile = urlToFile;
		this._rows = new ArrayList<CSVRecord>();
		this._headers = headers;
	}

	/**
	 * Allocates a CSVFile object and initializes it so that it represents. You
	 * have to include at least one header.
	 * 
	 * @param urlToFile is the path to file + file name + extension.
	 * @param separator of the fields in the csv.
	 * @param terminator of the row in the csv.
	 * @param headers of the csv file.
	 */
	public CSVFile( URL urlToFile, String separator, String terminator, String... headers ) {
		this( urlToFile, headers );
		this._separator = separator;
		this._terminator = terminator;
	}

	/**
	 * @return the _fileName
	 */
	public URL getURL() {
		return _urlToFile;
	}

	public void setURL( URL urlToFile ) {
		this._urlToFile = urlToFile;
	}

	/**
	 * @return the _separator
	 */
	public String getSeparator() {
		return _separator;
	}

	/**
	 * @param _separator the _separator to set
	 */
	public void setSeparator( String _separator ) {
		this._separator = _separator;
	}

	/**
	 * @return the _terminator
	 */
	public String getTerminator() {
		return _terminator;
	}

	/**
	 * @param _terminator the _terminator to set
	 */
	public void setTerminator( String _terminator ) {
		this._terminator = _terminator;
	}

	public String[] getHeaders() {
		return this._headers;
	}

	public void setHeaders( String... headers ) {
		this._headers = headers;
	}

	public void addRows( List<CSVRecord> rows ) {
		this._rows = rows;
	}

	public void addRow( CSVRecord row ) {
		this._rows.add( row );
	}

	public void addRow( String... values ) {
		CSVRecord row = new CSVRecord( this );
		row.addColumns( values );
		this._rows.add( row );
	}

	public List<CSVRecord> getRows() {
		return this._rows;
	}

	public CSVRecord getRowAt( int index ) {
		return this._rows.get( index );
	}

	public String getValueFromRow( int row, String header ) {
		return this._rows.get( row ).getColumn( header );
	}

	public static <K, T> CSVFile of( URL urlToFile, String separator, String... headers ) {

		CSVFile csv;

		csv = new CSVFile( urlToFile, headers );
		csv.setSeparator( separator );

		try (BufferedReader br = new BufferedReader(
				new FileReader( csv.getURL().getFileURL() ) )) {
			CSVRecord row;
			for (String line; ( line = br.readLine() ) != null;) {
				row = new CSVRecord( csv );
				String[] parts = line.split( csv.getSeparator() );
				for (String part : parts) {
					row.addColumn( part );
				}
				csv.addRow( row );
			}
			// line is not visible here.
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return csv;
	}

	public void save() {
		FileWriter fileWriter = null;
		try {
			fileWriter = new FileWriter( this.getURL().getFileURL() );
		} catch (IOException e) {
			e.printStackTrace();
		}
		PrintWriter printWriter = new PrintWriter( fileWriter );
		for (CSVRecord row : _rows) {
			StringBuilder sb = new StringBuilder();

			for (String header : _headers) {
				sb.append( row.getColumn( header ) );
				if (header != _headers[_headers.length - 1])
					sb.append( "," );
				else
					sb.append( "\n" );
			}
			printWriter.print( sb.toString() );
		}

		printWriter.close();
	}

}
