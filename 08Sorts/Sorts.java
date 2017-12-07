import java.util.Arrays;

public class Sorts{
    public static String name(){
	return "09.Canale.Britni";
    }

    public static boolean equals(int[] a, int [] b){
	if (a.length != b.length){
	    return false;
	}
	for(int i = 0; i < a.length; i++){
	    if (a[i] != b[i]){
		    return false;
	    }
	}
	return true;
    }

    public static void swap(int[] ary, int a, int b){
	int c =ary[a];                                                              
        ary[a] = ary[b];                                                            
        ary[b] = c;                           
    }

    public static void selectionSort(int[] ary){
	for(int i = 0; i + 1 < ary.length; i++){
	    int s = i;
	    for(int j = i + 1; j< ary.length; j++){
		if(ary[j] < ary[s]){
		    s = j;
		}
	    }
	    swap(ary, i, s);
	}
    }

    public static void insertionSort(int[] ary){
	for(int i = 1; i < ary.length; i++){
	    for(int j = i - 1; j >= 0 && ary[j] > ary[j+1]; j--){
		swap(ary, j, j + 1);
	    }
	}
    }



    public static void main(String[]ary){
        int[] randish = new int[250];
        for(int i = 0 ; i < randish.length; i++){
            randish[i] =(int)(Math.random()*100);
        }

        System.out.println(Arrays.toString(randish));
        //selectionSort(randish);
	insertionSort(randish);
        System.out.println(Arrays.toString(randish));
    }
}