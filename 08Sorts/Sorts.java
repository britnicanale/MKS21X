public class Sorts{
    public static String name(){
	return "09.Canale.Britni";
    }


    public static void swap(int[] ary, int a, int b){
	int c =ary[a];                                                              
        ary[a] = ary[b];                                                            
        ary[b] = c;                           
    }

    public static void selectionSort(int[] ary){
	for(int i = 0; i + 1 < ary.length; i++){
	    int s = i;
	    for(int j = i + 1; j < ary.length; j++){
		if(ary[j] < ary[i]){
		    s = j;
		}
	    }
	    swap(ary, i, s);
	}
    }
}