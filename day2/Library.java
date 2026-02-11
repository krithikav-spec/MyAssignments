package week2.day2;

public class Library {
	// Method addBook outside main with string
	public String addBook(String bookTitle) {
		System.out.println("Book added successfully");
		return bookTitle;
	}

	// Method addBook outside main with string
	public void issueBook() {
		System.out.println("Book issued sucessfully");

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//create object to call the method
		Library book = new Library();

		book.addBook("");
		book.issueBook();

	}

}
