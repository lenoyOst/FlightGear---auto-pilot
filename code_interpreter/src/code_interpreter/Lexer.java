package code_interpreter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
// simply a lexer , gets the raw code and separates it (by white spaces ext)
public class Lexer {
	//
	public ArrayList<String[]> lex(String fileName)
	{
		ArrayList<String[]> outScript = new ArrayList<>();
		try {
			BufferedReader fileIn = new BufferedReader(new FileReader(fileName));
			while(fileIn.ready())
			{
				outScript.add(fileIn.readLine().split("\s+"));
			}
		} catch (IOException e) {e.printStackTrace();}
		return outScript;
	}
	//
	public ArrayList<String[]> lex()
	{
		ArrayList<String[]> outScript = new ArrayList<>();
		String line;
		while((line = System.console().readLine())!= "done")
		{
			outScript.add(line.split("\s+"));
		}
		return outScript;
	}
}
