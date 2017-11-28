public class BookDriver{
    public static void main(String[] args){
	Book HP = new Book("The Goblet of Fire", "J.K. Rowling", "12345");
	System.out.println(HP);
	System.out.println(HP.getTitle());
	System.out.println(HP.getAuthor());
	System.out.println(HP.getIBSN());
	HP.setTitle("The Prisoner of Azkaban");
	HP.setAuthor("JK Rowling");
	HP.setIBSN("67890");
	System.out.println(HP);
    }
}