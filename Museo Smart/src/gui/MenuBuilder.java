package gui;


public interface MenuBuilder {
	
	public abstract void reset ();
	public abstract void createWindow (String title);
	public abstract void createPanel ();
	public abstract void createButtons (String... buttons);
	
}
