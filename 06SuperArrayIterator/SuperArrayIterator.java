import java.util.Iterator;

public class SuperArrayIterator implements Iterator<String>{
    private SuperArray data;
    private int current;
 
    public SuperArrayIterator(SuperArray supArr){
	data = supArr;
	current = 0;
    }

    public boolean hasNext(){
	return current <= data.size() - 1;
    }

    public void remove(){
	throw new UnsupportedOperationException();
    }

    public String next(){
	if (hasNext()){
	    current++;
	}else{
	    System.exit(0);
	}
	return data.get(current - 1);
    }
}