/*
 * This source file is part of the swift open source project.
 *
 * Copyright (c) 2017 Guillermo Facundo Colunga and the swift project authors.
 * Licensed under GNU General Public License v3.0.
 *
 * See /LICENSE for license information.
 * 
 * This class is based on the AlbUtil project.
 * 
 */
package AppKit;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import Foundation.CommandLine;

/**
 * Instance of NSAbstractMenu.java
 * 
 * @author Guillermo Facundo Colunga, based on the AlbUtil project.
 * @version 1.0
 */
public class NSMenu implements NSMenuAction, Serializable {

	private static final long serialVersionUID = -6625275915537248016L;

	protected static final int EXIT = 0;

	protected Object[][] menuOptions;
	private List<Class<NSMenuAction>> _actions = null;

	@Override public void execute() {
		int opt;

		do {
			showMenu();
			opt = getMenuOption();
			try {
				processOption( opt );

			} catch (RuntimeException rte) {
				System.out.println( rte );
				throw rte;
			} catch (Exception be) {
				System.out.println( be );
			}
		} while (opt != EXIT);
	}

	protected void processOption( int option ) throws Exception {
		if (option == EXIT)
			return;

		Class<NSMenuAction> actionClass = _actions.get( option - 1 );
		if (actionClass == null)
			return;

		_createInstanceOf( actionClass ).execute();
	}

	protected int getMenuOption() {
		Integer opt;

		do {
			CommandLine.print( "Opcion: ", null );
			opt = Integer.parseInt( CommandLine.readLine() );

		} while (opt == null || opt < EXIT);

		return opt;
	}

	protected void showMenu() {
		if (_actions == null) {
			_fillActions();
		}

		int opc = 1;
		printMenuHeader();
		for (Object[] row : menuOptions) {
			String text = (String) row[0];
			if (_isOptionRow( row )) {
				printMenuOption( opc++, text );
			} else {
				printMenuSeparator( text );
			}
		}
		printMenuFooter();
	}

	protected void printMenuSeparator( String text ) {
		CommandLine.print( text );
	}

	protected void printMenuOption( int opc, String text ) {
		CommandLine.print( "\t " + opc + "- " + text );
	}

	protected void printMenuFooter() {
		CommandLine.print( "" );
		CommandLine.print( "\t 0- Salir" );
	}

	protected void printMenuHeader() {
		CommandLine.print( "" );
	}

	private boolean _isOptionRow( Object[] row ) {
		return row[1] != null;
	}

	@SuppressWarnings("unchecked") private void _fillActions() {
		_actions = new ArrayList<Class<NSMenuAction>>();

		for (Object[] row : menuOptions) {
			if (row[1] != null) {
				_actions.add( (Class<NSMenuAction>) row[1] );
			}
		}
	}

	private NSMenuAction _createInstanceOf( Class<NSMenuAction> clazz ) {
		try {

			return (NSMenuAction) clazz.newInstance();

		} catch (InstantiationException e) {
			throw new RuntimeException( e );
		} catch (IllegalAccessException e) {
			throw new RuntimeException( e );
		}
	}

}
