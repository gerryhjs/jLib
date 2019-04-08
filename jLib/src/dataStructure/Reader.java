package dataStructure;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Reader {
		public static void main(String args[]) throws IOException
		{
			String file="c:\\ds\\words.txt"; //�ļ��б�
			String line; 
			FileInputStream inputstream = new FileInputStream(file); 
			StringBuffer buffer = new StringBuffer(); 
			BufferedReader bufferreader = new BufferedReader(new InputStreamReader(inputstream)); 
			while ((line = bufferreader.readLine()) != null) 
			{ 
				buffer.append(line); 
				buffer.append("\n"); 
			} 
			inputstream.close(); 
			bufferreader.close();
			System.out.println(buffer) ;
		}
}
