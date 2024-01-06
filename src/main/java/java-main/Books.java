public class Books {
    public static String name;
    public String author;
    public int isbn;
    public int year;

    public Books(String _name, String _author, int _isbn, int _year) {
        this.name = _name;
        this.author = _author;
        this.isbn = _isbn;
        this.year = _year;
 }
public String getValues(){
        return "Books name: " + name + ". Author: " + author + ". ISBN: " + isbn + ". Year: " + year + "\n";
}

}