abstract class LibraryBook extends Book implements Comparable<LibraryBook>{
    //Fields
    private String callNumber;

    //Constructors
    public LibraryBook(){
	super();
	callNumber = "";
    }

    public LibraryBook(String aut, String ti, String ibsn, String callNum){
	super(aut, ti, ibsn);
	callNumber = callNum;
    }
    public String getCallNumber(){
	return callNumber;
    }

    public void setCallNumber (String callNum){
	callNumber = callNum;
    }

    abstract void checkout(String patron, String due);
    abstract void returned();
    abstract String circulationStatus();

    public int compareTo(LibraryBook lb){
	return Integer.parseInt(callNumber) - Integer.parseInt(lb.getCallNumber());
    }

    public String toString(){
	return super.toString() + "Call Number: " + callNumber + " Circulation Status: " + circulationStatus();
    }
}