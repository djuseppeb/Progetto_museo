package gui;

public class DisplayDirector {
	private DisplayBuilder b;
	
	public DisplayDirector (DisplayBuilder b) {
		this.b = b;
	}
	
	public void changeBuilder (DisplayBuilder b) {
		this.b = b;
	}
	
	public void make (String title, String info, String... buttons) {
		b.reset();
		b.createWindow(title);
		b.createPanel(info);
		b.createButtons(buttons);
		
	}
}
