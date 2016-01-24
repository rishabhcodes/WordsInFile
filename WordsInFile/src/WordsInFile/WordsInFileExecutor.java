package WordsInFile;

import edu.duke.*;
import java.io.*;

public class WordsInFileExecutor {
	
	public static void main(String[] args){
		System.out.println("Please select the files: ");
		DirectoryResource dr = new DirectoryResource();
		WordsInFile wf = new WordsInFile();
		for (File e: dr.selectedFiles()){
			wf.parseFile(e);
			wf.printMap();
			wf.mostFreqWord();
			wf.wordsInFiles(2);
			
		}
	}

}
