package week2.day2;

//Create class Browser with two methods
public class Browser {
	// method launchBrowser with return
	public String launchBrowser(String browserName) {
		System.out.println("Browser launched sucessfully");
		return browserName;
	}

	// method loadUrl no return
	public void loadUrl() {
		System.out.println("Application launched sucessfully");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// create an object to access the methods
		Browser object = new Browser();
		object.launchBrowser("chrome");
		object.loadUrl();

	}

}
