
import org.joda.time.DateTime;
import org.joda.time.Duration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

public class Library {

    private ArrayList<Book> bookList;
    private ArrayList<User> userList;
    private  static final long FINEPERDAY = 2;

    public Library(){
        this.bookList  = new ArrayList<Book>();
        this.userList = new ArrayList<User>();


    }
/* @borrowBook method, the user can borrow the big by given book title,  if the book available, then
 change it is status to unavailable, set a date of lending it out and the supposed date of returning the book back.

 */
    public void borrowBook (User user, String title)throws Exception  {
        if(availableToBorrow(title)){
            user.addBook(bookList.get(indexBookByTitle(title)));
            bookList.get(indexBookByTitle(title)).setStatus(false);
            bookList.get(indexBookByTitle(title)).setBorrowedTime(new Date());
            bookList.get(indexBookByTitle(title)).setReturnTime();

        }
        else{
            throw  new Exception (" the book is borrowed ");

        }

    }
    /*
    @returnBook
     The user can return the book, the book availability status will change, the book will be removed from list of
     borrowedBooks and the method payFines will calculate and payment the user has to pay.
     */
    public long returnBook (User user, String title){
        long finesAmount = 0;
        Book returnedBook = bookList.get(indexBookByTitle(title));
        if(searchBook(title)){
             finesAmount = payFines(returnedBook);
             user.removeBook(returnedBook);
             returnedBook.setStatus(true);
        }
        return finesAmount;
    }

    /*
    @payFines method calculates the fines the user has to pay by calculating the total number of days
    between the returnTime ( 14 days after lending out the book) and the actual returnTime(when the user return
    the book) and multiply that by 2 kr/day.
     */

    public long payFines ( Book returnedBook ){
        DateTime returnedTime = new DateTime(returnedBook.getReturnTime());
        DateTime currentTime = new DateTime();
        Duration duration = new Duration(currentTime,returnedTime);  // I still have a problem if the user take the book
        long timeDifference = duration.getStandardDays();        // at morning and return it at night ?
        return  timeDifference * FINEPERDAY;                           // does casting work here ?
                                                                       // do u think i have to check here the two DATES!
        }




    public void addBook (Book book){
        bookList.add(book);
    }

    public void removeBook( Book book){
        bookList.remove(book);
    }

    public void sortBooks(){
        Collections.sort(bookList);
    }

    public boolean searchBook(String title){
        boolean status = false;

        for( Book item : bookList){
            if(item.getTitle().equals(title)){
                status = true;
            }
        }
        return  status;

    }

    public boolean availableToBorrow (String title){
        for(Book item : bookList){
            if(searchBook(title)&& item.isStatus()){
                return true;
            }
            else if(searchBook(title)&& !item.isStatus()){
                return false;
            }
        }
        return false;
    }

    public int indexBookByTitle(String title){
        int index = 0;
        if(searchBook(title)) {
            for (int i = 0; i < bookList.size(); i++) {
                if (bookList.get(i).getTitle().equals(title)) {
                    index= i;
                }

            }
        }
        return  index;
    }


    public void addUser(User User){
        userList.add(User);
    }

    public ArrayList<Book> getBookList() {
        return bookList;
    }
}