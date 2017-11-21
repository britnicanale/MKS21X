import java.util.*;
import java.io.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Arrays;

public class WordSearch{
    //Field Variables

    private char[][]data;
    private Random randgen;
    private ArrayList<String> wordsToAdd;
    private ArrayList<String> wordsAdded;



    //Constructors

    public WordSearch(){                                           //Prints instructions to use the WordSearch Generator
	System.out.println("Welcome to Word Search Generator! \nTo create a word search, type \"WordSearch(rows, cols, fileName),\" where rows is the amount of rows you want, cols is the amount of columns you want, and fileName is the name of a text file (.txt) that contains words you would like inserted into your Word Search. In addition, you could optionally add a Seed number to recreate an old Word Search if you use the same inputs. Use the syntax \"WordSearch(rows, cols, fileName, randSeed),\" to achieve this. Lastly, to print out an answer key, type \"WordSearch(rows, cols, fileName, randSeed, \"key\"),\" where the original four parameters are the same as those of the puzzle that you want the key of, and the last parameter is a String reading \"key.\" \nHappy Searching! ");
    }

    public WordSearch(int rows,int cols, String fileName){
	data = new char[rows][cols];
	clear();
	wordsToArray(fileName);                                     //Reads words from input file and puts them into ArrayList wordsToAdd.
	int seed = (int)(Math.random() * 10000);
	randgen = new Random(seed);                                 //Creates new instance of class Random with a randomized seed.
	addAllWords();                                              //Tries to add all of the words from the list given to the puzzle.
	fillIn();                                                   //Fills in remaining spaces with random characters.
	String print = "";
	for(int index = 0; index < wordsAdded.size(); index++){     //Creates a String of the words that were successfully added to the puzzle
	    print += wordsAdded.get(index) + "\t";
	    if(index % 3 == 2){
		print+= "\n";
	    }
	}
	System.out.println(this);                                   //Prints your puzzle
	System.out.println(print);                                  //Prints the String of added words.
	System.out.println("This is your seed: " + seed);           //Prints your random seed
    }


    //Uses random seed to initialize the puzzle, allows user to recreate an old puzzle.
    public WordSearch(int rows,int cols, String fileName, int randSeed){
        data = new char[rows][cols];
        clear();
        wordsToArray(fileName);                                     //Reads words from input file and puts them into ArrayList wordsToAdd.                     
        randgen = new Random(randSeed);                             //Creates new instance of class Random with an initialized seed.          
        addAllWords();                                              //Tries to add all of the words from the list given to the puzzle.                           
        fillIn();                                                   //Fills in remaining spaces with random characters.                                    
	System.out.println(this);                                   //Prints your puzzle      
        String print = "";

        for(int index = 0; index < wordsAdded.size(); index++){     //Creates a String of the words that were successfully added to the puzzle                   
            print += wordsAdded.get(index) + "\t";
            if(index % 3 == 2){
                print+= "\n";
            }
        }
        System.out.println(print);                                  //Prints the String of added words.                                                     
        System.out.println("This is your seed: " + randSeed);       //Prints your random seed
    }

    //Gives an option for a String input; if it reads "key" this will print a puzzle with just the input words (no random characters filled in)
    public WordSearch(int rows,int cols, String fileName, int randSeed, String key){
        data = new char[rows][cols];
        clear();
        wordsToArray(fileName);                                     //Reads words from input file and puts them into ArrayList wordsToAdd.                
        randgen = new Random(randSeed);                             //Creates new instance of class Random with an initialized seed.                       
        addAllWords();                                              //Tries to add all of the words from the list given to the puzzle.          
        if(!key.equals("key")){ 
	    fillIn();                                               //Only fills in remaining spaces with random characters if the user did not put "key,"
	}                 
	System.out.println(this);                                   //Prints your puzzle                        
        String print = "";
        for(int index = 0; index < wordsAdded.size(); index++){     //Creates a String of the words that were successfully added to the puzzle   
            print += wordsAdded.get(index) + "\t";
            if(index % 3 == 2){
                print+= "\n";
            }
        }

        System.out.println(print);                                  //Prints the String of added words.                                  
                                                                                                                                                  
        System.out.println("This is your seed: " + randSeed);       //Prints your random seed                                                                    
    }




    //Methods


    private void wordsToArray(String fileName){                     //Reads words from input file and puts them into ArrayList wordsToAdd.
	wordsToAdd = new ArrayList<String>();
	try{
	    File f = new File(fileName);
	    Scanner in = new Scanner(f);
	    while(in.hasNext()){
		String word = in.next();
		wordsToAdd.add(word.toUpperCase());                 //Goes through words in file, makes them uppercase and adds them to the ArrayList wordsToAdd
	    }
	}catch(FileNotFoundException e){                            //Catches exception and prints an error message.
	    System.out.println("File not found: " + fileName);
	    System.exit(1);
	}
    }


    //Set all values in the WordSearch to'_'
    private void clear(){              
	for(int index =0; index < data.length; index++){
            for (int subIndex = 0; subIndex < data[index].length; subIndex++){
                data[index][subIndex] ='_';
            }
	}
   }


    
    public String toString(){                                       //toString loops through all values in the 2D Array, separates them with spaces and 
	String retStr = "";                                         //separates each inner Array with a new line. 
	for(int index =0; index < data.length; index++){
            for (int subIndex = 0; subIndex < data[index].length; subIndex++){
                retStr += data[index][subIndex] + " ";
            }
	    retStr+= "\n";
        }
	return retStr;
    }



    //Checks to see if the word fits into the puzzle based off of its randomized direction and starting location.
    private boolean fits(String word,int col,int row,int cinc,int rinc){
	if(cinc < 0 && word.length() + 1 > row){
            return false;
        }
        else if(cinc > 0 && word.length() + 1 > data.length - row){
            return false;
        }
        if(rinc < 0&& word.length() + 1 > col){
            return false;
        }
        else if(rinc > 0 && word.length() + 1 > data[0].length - col){
            return false;
        }
	return true;
    }


    private boolean addWord(String word,int col,int row,int cinc,int rinc){
	if(fits( word, col, row, cinc, rinc)){
	    char[][] edited = new char[data.length][data[0].length]; //Creates a new 2D Array and initializes it as equal to data[][].
	    for(int index = 0; index < data.length; index++){
		for (int subIndex = 0; subIndex < data[index].length; subIndex++){
		    edited[index][subIndex]= data[index][subIndex];
		}
	    }
	    for(int index = 0; index < word.length(); index++){      //Adds words, checking if there is bad overlap
		if(data[index * cinc + row][index * rinc + col] != '_' && word.charAt(index)!= data[index * cinc + row][index * rinc + col]){
		    return false;
		}
		else{                                                //If there is no bad overlap, adds to edited[][] to preserve data[][] in case of error
		    edited[index * cinc + row][index * rinc + col] = word.charAt(index);
		}
	    }
	    data = edited;                                           //Sets data[][] equal to edited[][] if there are no errors.
	    wordsToAdd.remove(word);                                 //Moves successfully added words from ArrayList wordsToAdd to ArrayList wordsAdded.
	    wordsAdded.add(word);
	    return true;
	}
	return false;
    }

    //Calls addWord with random parameters
    private boolean addAllWords(){
	wordsAdded = new ArrayList<String>();
	for(int count = 0; count < data.length * data[0].length / 2 && 0 < wordsToAdd.size(); count++){  //Limits how many tries to addWord
	    int rinc = randgen.nextInt(3) - 1;
	    int cinc = randgen.nextInt(3) - 1;
	    if(!(rinc == cinc && cinc == 0)){
		addWord(wordsToAdd.get(randgen.nextInt(wordsToAdd.size())), randgen.nextInt(data[0].length),randgen.nextInt(data.length),cinc, rinc);
	    }
	}
	return true;
    }

    //Fills in the empty slots with random characters
    private void fillIn(){
	for(int index =0; index < data.length; index++){
            for (int subIndex = 0; subIndex < data[index].length; subIndex++){
                if(data[index][subIndex] == '_'){
		    char c = (char) (randgen.nextInt(26) + 65);
		    data[index][subIndex] = c;
		}
            }
        }
    }



    //Old addWord methods


    public boolean addWordHorizontal(String word,int row, int col){
        if(word.length() + 1 > data[0].length - col){
            return false;
        }
        char[][] edited = data;
        for(int index = col; index - col < word.length(); index++){
            if(data[row][index] != '_' && word.charAt(index - col)!= data[row][index]){
                return false;
            }
            else{
                edited[row][index] = word.charAt(index - col);
            }
        }
        data = edited;
        return true;
    }



    public boolean addWordVertical(String word,int row, int col){
        if(word.length() + 1 > data[0].length - row){
            return false;
        }
        char[][] edited = data;
        for(int index = row; index - row < word.length(); index++){
            if(data[index][col] != '_' && word.charAt(index - row)!= data[index][col]){
                return false;
            }
            else{
                edited[index][col] = word.charAt(index - row);
            }
        }
        data = edited;
        return true;
    }

    public boolean addWordDiagonal(String word,int row, int col){
        if(word.length() + 1 > data[0].length - row || word.length() + 1 > data[0].length - col){
            return false;
        }
        char[][] edited = data;
        for(int index = 0; index < word.length(); index++){
            if(data[index + row][index + col] != '_' && word.charAt(index)!= data[index+ row][index + col]){
                return false;
            }
            else{
                edited[index+ row][index + col] = word.charAt(index);
            }
        }
        data = edited;
        return true;
    }

}
