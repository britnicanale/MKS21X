public class Barcode implements Comparable<Barcode>{
    private String zip;

    //CONSTRUCTOR: Checks to make sure the zip has integer values and that its length is 5
    public Barcode(String z){
	try{
	    Integer.parseInt(z);
	}catch(NumberFormatException e){
	    throw new IllegalArgumentException();
	}
	if(z.length() != 5){
	    throw new IllegalArgumentException();
	}
	zip = z;
    }


    //TOSTRING

    //toString: Calls static method to construct code and adds the zip
    public String toString(){
	return toCode(zip) + " (" + zip + ")";
    }


    //COMPARABLE IMPLEMENTATION

    //compareTo: Compares the zips of two Barcodes
    public int compareTo(Barcode other){
	return Integer.parseInt(zip) - Integer.parseInt(other.getZip());
    }


    //STATIC METHODS

    //toCode: static, checks length of zip and makes sure it has integer values, creates a code using a zip 
    public static String toCode(String zip){
	if(zip.length() != 5){
	    throw new IllegalArgumentException();
	}
	String code = "|";
	String[] convert = new String[] {"||:::",":::||","::|:|","::||:",":|::|",":|:|:",":||::","|:::|","|::|:","|:|::"};
	for(int i = 0; i < 5; i++){
	    try{
		code+= convert[Character.getNumericValue(zip.charAt(i))];
	    }
	    catch(NumberFormatException e){
		throw new IllegalArgumentException();
	    }
	}
	code += convert[getCheck(zip)]+ "|";
	return code;
    }

    //getCheck: private and static, used by toCode and toZip to add and check the checksum, makes sure zip is valid
    private static int getCheck(String zip){
	int total = 0;
	if(zip.length() != 5){
            System.out.println(zip.length());
	    throw new IllegalArgumentException();
        }
	for(int i = 0; i < 5; i++){
	    try{
		total+=Character.getNumericValue(zip.charAt(i));
	    }
	    catch(NumberFormatException e){
                throw new IllegalArgumentException();
	    }
	}
	return total % 10;
    }

    //toZip, checks validity of input code, returns zip if it is valid
    public static String toZip(String code){
	String zip = "";
        String[] convert = new String[] {"||:::",":::||","::|:|","::||:",":|::|",":|:|:",":||::","|:::|","|::|:","|:|::"};
	if((code.charAt(0) != '|'|| code.length() != 32) || code.charAt(31) != '|'){
	    throw new IllegalArgumentException();
	}
	for(int i = 1; i < 26; i += 5){
	    for(int j = 0; j < 10; j++){
		if(code.substring(i, i+5).equals(convert[j])){
		    zip+=j;
		}
	    }
	}
	if(zip.length() < 5){
	    throw new IllegalArgumentException();
	}
	if(!code.substring(26,31).equals(convert[getCheck(zip)])){
	    throw new IllegalArgumentException();
	}
	return zip;
    }


    //ACCESSOR METHODS

    //getCode() Uses toCode to return code of the Barcode
    public String getCode(){
	return toCode(zip);
    }

    //getZip() returns zip
    public String getZip(){
	return zip;
    }
    
}
