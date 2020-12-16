package gui;


public class Client {
	
	public static void main(String[] args) {
		HomeMenuBuilder hmb = new HomeMenuBuilder();   // create a HomeMenuBuilder
		MenuDirector d = new MenuDirector(hmb);        // create a MenuDirector
		
		// get home GUI (menu)
		d.make("Home", "Stanze", "Opere");
		hmb.getProduct();
		
	}
	
}