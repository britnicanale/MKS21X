public class ReversedCharSequence implements CharSequence{
    private String data;
    public ReversedCharSequence(String charSeq){
	data = "";
	for(int i = charSeq.length() - 1; i >= 0; i--){
	    data += charSeq.charAt(i);
	}
    }
    public char charAt(int index){
	return data.charAt(index);
    }
    public int length(){
	return data.length();
    }
    public ReversedCharSequence subSequence(int start, int end){
	ReversedCharSequence ret = new ReversedCharSequence(data.substring(start, end));
	return ret;
    }  
    public String toString(){
	return data;
    }
}