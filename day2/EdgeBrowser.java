package week2.day2;

public class EdgeBrowser {
//call method from different class in the same package
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//create new object to call  methods from Browser.java class
		Browser obj = new Browser();
	    obj.launchBrowser("chrome");
		obj.loadUrl();
	}

}
