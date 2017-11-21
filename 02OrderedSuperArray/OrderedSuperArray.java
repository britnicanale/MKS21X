public class OrderedSuperArray extends SuperArray{
    public OrderedSuperArray(){
	super();
    }

    public OrderedSuperArray(int startingCapacity){
	super(startingCapacity);
    }

    public OrderedSuperArray(String[] ary){
	super(ary.length);
	for(int index = 0; index < ary.length; index++){
	    add(ary[index]);
	}
    }

    public String set(int index, String value){
	throw new UnsupportedOperationException();
    }

    public void add(int index, String value){
	add(value);
    }


    private int findIndex(String value){
	for(int index = 0; index < size(); index++){
	    if(value.compareTo(get(index)) < 0){
		return index;
	    }
	}
	return size();
    } 


    private int findIndexBinary(String value){
	int end = size();
        int start = 0;
	int index = -1;
        while(size() != 0 && end != start){
            if(get(start + ((end - start) / 2)).compareTo(value) < 0){
                if(end - start > 1){
                    start += ((end - start) / 2);
                }
                else{
                    start+= 1;
                }
            }
            else{
                if(end - start > 1){
                    end -= ((end -start) / 2);
                }
                else{
                    end -= 1;
                }
            }
        }
	return end;
    }

    public boolean add(String value){
	super.add(findIndexBinary(value), value);
	return true;
    }
}

