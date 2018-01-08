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
	String sub = data.substring(start, end);
	String reverse = "";
	for(int i = sub.length() - 1; i >= 0; i--){
            reverse  += sub.charAt(i);
        }
	ReversedCharSequence ret = new ReversedCharSequence(reverse);
	return ret;
    }  
    public String toString(){
	return data;
    }
    public static void main(String[] args){
	ReversedCharSequence backwards = new ReversedCharSequence("backwards");
	System.out.println(backwards.charAt(0));
	System.out.println(backwards.length());
	System.out.println(backwards.subSequence(0, 4));
	System.out.println(backwards);
    }
}