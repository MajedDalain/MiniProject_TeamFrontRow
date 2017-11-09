public class Mainclass {
    public static  void  main (String [] args){

        Library SEM = new Library();
        try{

            User Majed = new User("Majed","1990/12/07","Blidvadersgatan","100");
            User Matt = new User("Matt","1994/08/01","kungsgatan","101");
            SEM.addUser(Majed);
            SEM.addUser(Matt);

            Book booknew  = new Book("love","Majed","empty","fantasy","Henrik","10B");
            Book secondBook = new Book("what","Filip", "Stribog","fantasy","Naief","20C");


            SEM.addBook(booknew);
            System.out.println(booknew.getBorrowedTime());
            System.out.println(booknew.getReturnTime());

            SEM.addBook(secondBook);
            System.out.println(secondBook.getBorrowedTime());
            System.out.println(secondBook.getReturnTime());

            SEM.borrowBook(Majed, "love");
            System.out.println(booknew.getBorrowedTime());
            System.out.println(booknew.getReturnTime());

            SEM.borrowBook(Matt, "what");
            System.out.println(secondBook.getBorrowedTime());
            System.out.println(secondBook.getReturnTime());

            System.out.println(Majed.getBorrowedBooks());
            System.out.println();



        }
        catch (Exception e){
            System.out.println(e);
        }
//        Book booktwo = new Book ("java", "fransico", "eductaion","javafirst","19B","10A");
//        SEM.addBook(booktwo);
//        System.out.println(SEM.getBookList());
//        SEM.sortBooks();
//        System.out.println(SEM.getBookList());


    }







}