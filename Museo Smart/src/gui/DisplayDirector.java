package gui;

import java.util.ArrayList;

public class DisplayDirector {
	private DisplayBuilder b;
	
	public DisplayDirector (DisplayBuilder b) {
		this.b = b;
	}
	
	public void changeBuilder (DisplayBuilder b) {
		this.b = b;
	}
	
	public DisplayBuilder getDisplayBuilder() {
		return this.b;
	}
	
	public void make (String title, ArrayList<String> info, String... buttons) {
		b.reset();
		b.createWindow(title);
		b.createPanel(info);
		b.createButtons(buttons);
		
	}
}
