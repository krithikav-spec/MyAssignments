package practice.self;

public class JavaChallenge1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a = "Hello world";
		// To split the sentence using space
		String[] split = a.split(" ");
		
		String lastWord = split[split.length - 1];
		System.out.println("Input 1 " + a);
		System.out.println("The length of the last word in input1 is " + lastWord.length());

		String b = "fly me to the moon";
		String[] split2 = b.split(" ");
		String lastWord2 = split2[split2.length - 1];
		System.out.println("Input 2 " + b);
		System.out.println("The length of the last word in input2 is " + lastWord2.length());

		String c = "luffy is still joyboy";
		String[] split3 = c.split(" ");
		String lastWord3 = split3[split3.length - 1];
		System.out.println("input 3" + c);
		System.out.println("The length of the last word in input3 is " + lastWord3.length());
	}

}
