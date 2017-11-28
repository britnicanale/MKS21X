public class Book{
    //Field Variables
    private String author;
    private String title;
    private String IBSN;


    //Constructors
    public Book(){
	author = "";
	title = "";
	IBSN = "";
    }

    public Book(String aut, String ti, String ibsn){
	author = aut;
	title = ti;
	IBSN = ibsn;
    }


    //Getters
    public String getAuthor(){
	return author;
    }

    public String getTitle(){
	return title;
    }

    public String getIBSN(){
	return IBSN;
    }


    //Setters
    public void setAuthor(String aut){
	author = aut;
    }
    
    public void setTitle(String ti){
	title = ti;
    }
    
    public void setIBSN(String ibsn){
	IBSN = ibsn;
    }


    //toString
    public String toString(){
	return "\"" + title + "\" by " + author + "IBSN: " + IBSN;
    }
}