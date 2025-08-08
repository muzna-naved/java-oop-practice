public class BookInfo {

    private static int noOfBooks = 0;

    public String title = "Learning Java";
    public String author = "Deitel";
    public String publisher = "Pearson";
    public int yearPublished = 2020;
    private String password = "1234";

    public BookInfo(){
        noOfBooks+=1;
    }

    public static int getNoOfBooks() {
        return noOfBooks;
    }

    public BookInfo(String title, String author, String publisher, int yearPublished) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.yearPublished = yearPublished;
    }

    // public class EBookInfo extends BookInfo {
    //     public String folderPath = " ";

    //     public EBookInfo() {
    //         super();
    //     }
    //     public EBookInfo(String title, String author, String publisher, int yearPublished, String eBookPath) {
    //         super(title, author, publisher, yearPublished);
    //         this.folderPath = eBookPath;
    //     }
    //     public EBookInfo(String title, String author, String publisher, int yearPublished) {
    //         super(title, author, publisher, yearPublished);
    //     }
    
        
    // }

}


