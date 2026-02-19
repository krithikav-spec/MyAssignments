package week3.day7;

public class LoginTestData extends TestData {
	public void enterUsername() {
		System.out.println("enterUsername method");
	}

	public void enterPassword() {
		System.out.println("enterPassword method");
	}

	public static void main(String[] args) {

		System.out.println("TestData methods:");
		TestData obj = new TestData();
		obj.enterCredentials();
		obj.navigateToHomePage();

		System.out.println("LoginTestData methods:");
		LoginTestData obj2 = new LoginTestData();
		
		obj2.enterUsername();
		obj2.enterPassword();	
		obj2.enterCredentials();
		
		
	}
}
