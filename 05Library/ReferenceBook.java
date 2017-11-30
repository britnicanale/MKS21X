public class ReferenceBook extends LibraryBook{
    private String collection;

    public ReferenceBook(String aut, String titl, String ibsn, String callNum, String coll){
	super(aut, titl, ibsn, callNum);
	collection = coll;
    }

    public String getCollection(){
	return collection;
    }

    public void setCollection(String coll){
	collection = coll;
    }

    public void checkout(String patron, String due){
	System.out.println(patron + " cannot check out a reference book");
    }

    public void returned(){
	System.out.println("Reference book could not have been checked out -- return impossible");
    }

    public String circulationStatus(){
	return "Non-circulating reference book";
    }

    public String toString(){
	return super.toString() + " Collection: " + collection;
    }
}