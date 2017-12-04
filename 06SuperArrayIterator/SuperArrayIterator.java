import java.util.Iterator;

public class SuperArrayIterator implements Iterator<String>{
    private SuperArray data;
    private int current, end;
 
    public SuperArrayIterator(SuperArray supArr){
	data = supArr;
	current = 0;
	end = data.size()
    }

    public boolean hasNext(){
	return current <= end;
    }

    public void remove(){
	throw new UnsupportedOperationException():
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