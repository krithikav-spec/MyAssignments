package week2.day3;

public class Stringreverse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String companyName = "TestLeaf";
		char[] charArray = companyName.toCharArray();
		
		for (int i= companyName.length()-1; i >= 0; i--){
		System.out.print(charArray[i]);
		}
	}

}
