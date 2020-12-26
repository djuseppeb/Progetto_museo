package gui;


public class MenuDirector {
	private MenuBuilder b;
	
	public MenuDirector (MenuBuilder b) {
		this.b = b;
	}
	
	public void changeBuilder (MenuBuilder b) {
		this.b = b;
	}
	
	public MenuBuilder getMenuBuilder() {
		return this.b;
	}
	
	public void make (String title, String... buttons) {
		b.reset();
		b.createWindow(title);
		b.createPanel();
		b.createButtons(buttons);
	}
}
