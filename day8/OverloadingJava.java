package week3.day8;

public class OverloadingJava {
	
	public void reportStep(String msg , String status) {
		System.out.println("Printing String msg, status " +msg +status);
	}
	public void reportStep(String msg1 , String status1, boolean snap) {
		System.out.println("Printing String msg1, status1, snap " +msg1 +status1 +snap);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		OverloadingJava option= new OverloadingJava();
		option.reportStep("hi", "pass");
		option.reportStep("Hello", "fail",true);
	}

}
