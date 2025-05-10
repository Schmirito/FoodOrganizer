package backend;

import frontend.Homepage;
import frontend.LoginPage;

public class AppManager {

	
	public static void main(String[] args) {
		
		AppManager am = new AppManager();
		
	}

	public AppManager() {
		frontend.LoginPage loginPage = new LoginPage(this);
		loginPage.setVisible(true);
	}
	
	public void loginSuccessful() {
		System.out.println("back in Manager");
		Homepage frame = new Homepage();
		frame.setVisible(true);
	}
}
