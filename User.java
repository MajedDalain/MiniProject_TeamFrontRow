import java.awt.print.Book;
import java.util.ArrayList;

public class User extends Person {
    private ArrayList<Book> borrowedBooks;

    public User (String name, String DOB, String address, String ID) throws Exception{
        super(name,DOB,address,ID);
        this.borrowedBooks = new ArrayList<>();

    }

    public ArrayList<Book> getBorrowedBooks() {
        return borrowedBooks;
    }
    public void addBook(Book borrowedBook){
        borrowedBooks.add(borrowedBook);
    }
    public  void removeBook(Book returnedBook){
        borrowedBooks.remove(returnedBook);
    }

    @Override
    public String toString() {
        return super.getName();
    }

}