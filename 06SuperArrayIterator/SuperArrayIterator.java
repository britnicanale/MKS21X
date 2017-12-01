public class SuperArrayIterator implements Iterator<Integer>{
    private SuperArray data;
    private int current;
 
    public SuperArrayIterator(SuperArray supArr, int curr){
	data = supArr;
	current = curr;
    }

    public boolean hasNext(){
	return current <= data.size();
    }

    public Integer next(){
	if (hasNext()){
	    current++;
	}else{
	    System.exit(0);
	}
	return current - 1;
    }
}