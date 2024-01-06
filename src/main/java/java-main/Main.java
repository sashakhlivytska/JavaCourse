import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Books> booksList = new ArrayList<>();

        // Create book library through cycle
        for (int i = 0; i < 2; i++) {
            System.out.println("Введіть назву книги: ");
            String name = scanner.nextLine();

            System.out.println("Введіть автора книги: ");
            String author = scanner.nextLine();

            System.out.println("Введіть ISDN номер: ");
            int isbn = scanner.nextInt();

            System.out.println("Введіть рік книги: ");
            int year = scanner.nextInt();
            scanner.nextLine();

            Books myBook = new Books(name, author, isbn, year);
            booksList.add(myBook);
            System.out.println();
        }

        //view book library
        for (int i = 0; i < booksList.size(); i++) {
            Books myBook = booksList.get(i);
            System.out.println("Книга #" + (i + 1));
            System.out.println("Назва: " + myBook.name);
            System.out.println("Автор: " + myBook.author);
            System.out.println("ISDN номер: " + myBook.isbn);
            System.out.println("Рік видання: " + myBook.year);
            System.out.println();
        }
        //search your book
        System.out.println("Введіть назву книги яку хочете знайти: ");
        String name = scanner.nextLine();
        boolean notFound = true;
        if(name.equals(Books.name)){
            notFound = false;
            System.out.println("Книгу: " + name + " знайдено." + "\n");
        }
        if (notFound){
            System.out.println("Книгу " + name + " не знайдено." + "\n");
        }
        // delete ypur book with ISBN code
        System.out.println("Введіть номер ISBN книги, яку хочете видалити: ");
        int isbnToDelete = scanner.nextInt();
        boolean bookDeleted = false;

        for (int i = 0; i < booksList.size(); i++) {
            if (booksList.get(i).isbn == isbnToDelete) {
                booksList.remove(i);
                bookDeleted = true;
                System.out.println("Книгу " + isbnToDelete + " видалено.");
                break;
            }
        }

        if (!bookDeleted) {
            System.out.println("Книгу " + isbnToDelete + " не знайдено.");
        }


        scanner.close();
    }
}
