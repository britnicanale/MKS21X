import java.util.*;

public class SuperArray implements Iterable<String>{
    private int size;
    private String[] data;

    public SuperArray(){
        data = new String[10];
        size = 0;
    }

    public SuperArray(int startingCapacity){
        data = new String[startingCapacity];
        size = 0;
    }

    public void clear(){
        data = new String[10];
        size = 0;
    }
    public int size(){
        return size;
    }
    public boolean isEmpty(){
        return size() == 0;
    }
    public boolean add(String element){
        resize();
        data[size] = element;
        size++;
        return true;
    }
    public String toString(){
        int index = 0;
        String returnString = "[";
        if(size == 0){
            return returnString + "]";
        }
        for(; index + 1 < size; index++){
            returnString += data[index] + ", ";
        }
        returnString += data[index] + "]";
        return returnString;
    }
    public String get(int index){
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Index = " + index + "; Size = " + size);
        }
	return data[index];
    }
    public String set(int index, String element){
        if(index < 0 ||index >= size){
            throw new IndexOutOfBoundsException("Index = " + index + "; Size = " + size);
        }
        String oldStr = data[index];
        data[index] = element;
        return oldStr;
    }
    private void resize(){
        if(data.length == size){
            String[] newData = new  String[size * 2 + 1];
            for(int index = 0; index < size; index++){
                newData[index] = data[index];
            }
            data = newData;
        }
    }
    public boolean contains(String target){
	for(int index = 0; index < size; index++){
            if(data[index].equals(target)){
                return true;
            }
        }
        return false;
    }
    public int indexOf(String element){
        for(int index = 0; index < size; index++){
            if(data[index].equals(element)){
                return index;
            }
        }
        return -1;
    }
    public int lastIndexOf(String element){
        for(int index = size - 1; index >= 0; index--){
            if(data[index].equals(element)){
                return index;
            }
        }
        return -1;
    }
    public void add(int index, String element){
        resize();
        if(index < 0 || index > size){
            throw new IndexOutOfBoundsException("Index = " + index + "; Size = " + size);
        }
        else{
            for(int count = size - 1; count >= index; count--){
                data[count + 1] = data[count];
            }
            data[index] = element;
            size++;
        }
    }
    public String remove(int index){
        if(index < 0 ||index >= size){
            throw new IndexOutOfBoundsException("Index = " + index + "; Size = " + size);
        }
        String removed = data[index];
        for(int count = index; count < size; count++){
            data[count] = data[count + 1];
        }
        size--;
        return removed;
    }
    public boolean remove(String element){
        if(!contains(element)){
            return false;
        }
        for(int count = indexOf(element); count < size; count++){
            data[count] = data[count + 1];
	}
        size--;
        return true;
    }

    //Iterable 
    public Iterator<String> iterator(){
	return new SuperArrayIterator(this);
    }
}




