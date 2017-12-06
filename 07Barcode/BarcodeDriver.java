public class BarcodeDriver {
    public static void main(String[] args) {
	Barcode y = new Barcode("11133");
	Barcode x = new Barcode("11111");
	System.out.println(y);
	System.out.println(y.getZip());
	System.out.println(y.getCode());
	System.out.println(x.equals(y));
	System.out.println(x.compareTo(y));
	System.out.println("________________NEW TESTS_____________________");
	Barcode a = new Barcode("11245");
	Barcode b = new Barcode("38760");
	Barcode c = new Barcode("11245");
	Barcode d = new Barcode("00294");

	System.out.println(a.getZip());//11245
	System.out.println(d.getZip());//00234
	System.out.println(a.getCode());// |:::||:::||::|:|:|::|:|:|:::||:|
	System.out.println(a.toString());// |:::||:::||::|:|:|::|:|:|:::||:| (11245)
	System.out.println(b);// |::||:|::|:|:::|:||::||::::|::|| (38760)
	System.out.println(c);// |:::||:::||::|:|:|::|:|:|:::||:| (11245)
	System.out.println(d);// |||:::||:::::|:||:|:::|::|:|:|:| (00294)
	System.out.println(a.compareTo(b));// negative
	System.out.println(a.compareTo(c));// 0
	System.out.println(a.compareTo(d));// positive
	System.out.println(a.equals(b));// false
	System.out.println(a.equals(c));// true
	System.out.println(a.equals(d));// false

	System.out.println("________________NEW TESTS_____________________");

	//Barcode e = new Barcode("12sa1"); //Should throw an error, sa not valid nums
	//Barcode f = new Barcode("12312312"); //Should throw an error, too many nums
	//Barcode.toCode("131"); //Should throw an error, too little nums
	//Barcode.toCode("123dasda"); //Should throw an error, dasda are not valid #s
	//Barcode.toZip("|||:::||:::::|:||:|:::|::|:|:|::|"); //Should throw an error, Way too long
	//Barcode.toZip(":||:::||:::::|:||:|:::|::|:|:|::|"); //Should throw an error, should not end with :
	//Barcode.toZip(":||:::||:::::|:||:|:::|::|:||:::|"); //Should throw an error, checkSum incorrect
	//Barcode.toZip("|::::::|:::::|:||:|:::|::|:|:|::|"); //Should throw an error, ::::: found

    }
}