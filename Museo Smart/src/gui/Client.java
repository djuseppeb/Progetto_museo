package gui;


public class Client {
	
	public static void main(String[] args) {
		MainMenuBuilder mmb = new MainMenuBuilder();   // create a HomeMenuBuilder
		MenuDirector d = new MenuDirector(mmb);        // create a MenuDirector
		
		// get home GUI (menu)
		d.make("Home", "Stanze", "Opere");
		mmb.getProduct();
		
	}
	
}