package gui;

import java.util.ArrayList;

public interface DisplayBuilder {
	public abstract void reset ();
	public abstract void createWindow (String title);
	public abstract void createPanel (ArrayList<String> info);
	public abstract void createButtons (String... buttons);
}
