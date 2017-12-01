public class CirculatingBook extends LibraryBook{
    private String currentHolder;
    private String dueDate;

    public CirculatingBook(String aut, String titl, String ibsn, String callNum){
	super(aut, titl, ibsn, callNum);
	currentHolder = "";
	dueDate = "";
    }

    public String getCurrentHolder(){
	return currentHolder;
    }

    public String getDueDate(){
	return dueDate;
    }

    public void setCurrentHolder(String currHol){
	currentHolder = currHol;
    }

    public void setDueDate(String date){
	dueDate = date;
    }

    public void checkout(String patron, String due){
	currentHolder = patron;
	dueDate = due;
    }

    public void returned(){
	currentHolder = "";
	dueDate = "";
    }

    public String circulationStatus(){
	if(currentHolder.equals("")){
	    return " Book available on shelves";
	}
	return "\nCurrent Holder: " + currentHolder + "\nDue Date: " + dueDate;
    }

    public String toString(){
        if(currentHolder.equals("")){
            return super.toString();
        }
        return super.toString() + circulationStatus();
    }
}