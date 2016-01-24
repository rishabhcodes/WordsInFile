package WordsInFile;

import java.io.*;
import java.util.*;
import edu.duke.*;

public class WordsInFile {
	private HashMap<String, ArrayList<String>> mymap = new HashMap<String, ArrayList<String>>();
	
	public void parseFile(File f){
		String file_name = f.getName();
		FileResource fr = new FileResource(f);
		String[] allwords;
		String s = fr.asString().trim().toLowerCase();
		allwords = s.split("[ \t\n\\x0B\f\r]+");
		addToMap(allwords, file_name);
	}
	
	private void addToMap(String[] s, String file_name){
		for (int i =0; i<s.length;i++){
			if (mymap.containsKey(s[i])){
				updateForKey(s[i], file_name);
			}else {
				addForKey(s[i], file_name);
			}
		}
	}
	
	private void updateForKey(String key, String file_name){
		if (!mymap.get(key).contains(file_name)){
			mymap.get(key).add(file_name);
		}
		
	}

	private void addForKey(String key, String file_name){
		mymap.put(key, new ArrayList<String>());
		mymap.get(key).add(file_name);
	}
	
	public void printMap(){
		for (String e: mymap.keySet()){
			System.out.println(e+"\t"+mymap.get(e).toString());
		}
	}
	
	public HashMap <String, Integer> mostFreqWord(){
		HashMap <String, Integer> value = new HashMap <String, Integer>();
		int max_value = 0;
		String max_word = "";
		for (String e: mymap.keySet()){
			if (mymap.get(e).size()>max_value){
				max_value = mymap.get(e).size();
				max_word = e;
				value.put(max_word, max_value);
			}
		}
		System.out.println("The most frequent word is: "+max_word+ " & number of files in which is occurs is: "+max_value);
		return value;
	}
	
	public ArrayList<String> wordsInFiles(int i){
		ArrayList<String> words = new ArrayList<String>();
		for (String e: mymap.keySet()){
			if (mymap.get(e).size() == i){
				words.add(e);
			}
		}
		System.out.println(words.toString());
		return words;
	}
}
