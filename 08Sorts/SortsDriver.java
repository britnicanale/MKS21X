import java.util.Arrays;

public class SortsDriver{
    public static void main(String[]ary){                                         
	int[] randish = new int[15];                                                
	for(int i = 0 ; i < randish.length; i++){                                   
	    randish[i] =(int)(Math.random()*100);                                   
	}                                                                           
                                                                                   
	System.out.println(Arrays.toString(randish));                               
	selectionSort(randish);                                                  
	System.out.println(Arrays.toString(randish));                              
    }                                                                               
}                                                 