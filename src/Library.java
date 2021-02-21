import java.util.ArrayList; 

public class Library {
    // Add the missing implementation to this class
		private String address;
		private ArrayList<Book> catalog = new ArrayList<Book>();
		
		public Library(String address) {
			this.address = address;
		}
		
		//Getters
		public String getAddress() {
			return address;
		}

		public ArrayList<Book> getCatalog() {
			return catalog;
		}
		
		//Setters
		public void setAddress(String address) {
			this.address = address;
		}
		
		public void setCatalog(ArrayList<Book> catalog) {
			this.catalog = catalog;
		}
		
		//Class Methods
		public void addBook(Book book) {
			getCatalog().add(book);
		}
		
		public static void printOpeningHours() {
			System.out.println("Libraries are open daily from 9am to 5pm.");
		}
		
		public void printAddress() {
			System.out.println(this.address);
		}
		
		public void borrowBook(String title){
			for(Book book: this.catalog){
				if(title.equals(book.getTitle())){
					if(book.isBorrowed()){
						System.out.println("Sorry, this book is already borrowed.");
						return;
					}
					else{
						book.borrowed();
						System.out.println("You succesfully borrowed " + book.getTitle());
						return;
					}
				}
			}
			System.out.println("Sorry, this book is not in our catalog");
		}
		
		public void printAvailableBooks() {
			if(this.catalog.isEmpty()){
				System.out.println("No book available in the catalog");
			}
			
			for(Book book:this.catalog){
				System.out.println(book.getTitle());
				if(book.isBorrowed()){
				System.out.println(book.getTitle()+" "+"is not available");
				}
			}
		}
		
		public void returnBook(String title){
			for(Book book:this.catalog){
				if(title.equals(book.getTitle())){
					book.returned();
					System.out.println("You successfully returned"+ " "+book.getTitle());
				}
			}
		}
				
		
	public static void main(String[] args) {
        // Create two libraries
        Library firstLibrary = new Library("10 Main St.");
        Library secondLibrary = new Library("228 Liberty St.");

        // Add four books to the first library
        firstLibrary.addBook(new Book("The Da Vinci Code"));
        firstLibrary.addBook(new Book("Le Petit Prince"));
        firstLibrary.addBook(new Book("A Tale of Two Cities"));
        firstLibrary.addBook(new Book("The Lord of the Rings"));

        // Print opening hours and the addresses
        System.out.println("Library hours:");
        printOpeningHours();
        System.out.println();

        System.out.println("Library addresses:");
        firstLibrary.printAddress();
        secondLibrary.printAddress();
        System.out.println();

        // Try to borrow The Lords of the Rings from both libraries
        System.out.println("Borrowing The Lord of the Rings:");
        firstLibrary.borrowBook("The Lord of the Rings");
        firstLibrary.borrowBook("The Lord of the Rings");
        secondLibrary.borrowBook("The Lord of the Rings");
        System.out.println();

        // Print the titles of all available books from both libraries
        System.out.println("Books available in the first library:");
        firstLibrary.printAvailableBooks();
        System.out.println();
        System.out.println("Books available in the second library:");
        secondLibrary.printAvailableBooks();
        System.out.println();

        // Return The Lords of the Rings to the first library
        System.out.println("Returning The Lord of the Rings:");
        firstLibrary.returnBook("The Lord of the Rings");
        System.out.println();

        // Print the titles of available from the first library
        System.out.println("Books available in the first library:");
        firstLibrary.printAvailableBooks();
    }
} 
