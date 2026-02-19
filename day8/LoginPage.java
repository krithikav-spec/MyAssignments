package week3.day8;

public class LoginPage extends MethodOverriding{
	
	public void performCommonTasks() {
		System.out.println("this is performCommonTasks method of LoginPage " );}

	public static void main(String[] args) {
		LoginPage object = new LoginPage();
		object.clickElement();
		object.findElement();
		object.enterText();
		object.performCommonTasks();
		
		

	}

}
