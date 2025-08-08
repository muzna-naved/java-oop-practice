public class Main {
    public static void main(String[] args) {
        BookInfo book1 = new BookInfo();
        BookInfo book2 = new BookInfo();
        BookInfo book3 = new BookInfo();
        System.out.println("Title: " + book1.title);
        System.out.println("Author: " + book2.author);
        System.out.println(book3.yearPublished);
        System.out.println("Total number of books: " + BookInfo.getNoOfBooks());
        EBookInfo ebook1 = new EBookInfo("Java Programming", "John Doe", "Tech Press", 2021, " ");
        System.out.println("EBook Title: " + ebook1.title);
    }
}
