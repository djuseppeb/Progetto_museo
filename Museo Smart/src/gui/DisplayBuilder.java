package gui;

public interface DisplayBuilder {
	public abstract void reset ();
	public abstract void createWindow (String title);
	public abstract void createPanel (String info);
	public abstract void createButtons (String... buttons);
}
