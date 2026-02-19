package week3.day7;

public class Elements extends RadioButton {

	public static void main(String[] args) {

		
		Elements obj = new Elements();
		
		//from webelement class
		obj.click();
		obj.setText("test1");
		//from button class
		obj.submit();
		//from clickCheckButton class
        obj.clickCheckButton();
        //from radiobutton class
	    obj.selectRadioButton();
	}}