package net.pawstep.editor;

import java.util.logging.Logger;

public class PawEditor {
	
	private static PawEditor editor;
	
	private Logger logger = Logger.getLogger("PawEditor");
	
	private PawEditor() {
		
	}
	
	public static PawEditor getEditor() {
		return editor;
	}
	
	public Logger getLogger() {
		return this.logger;
	}
	
	public static void main(String[] args) {
		
		// TODO Do initialization stuff.
		
		editor = new PawEditor();
		
	}
	
}
