package usingJavaAPI;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
/*
	Rafiqul Islam
	
*/
public class Executing_Linux_bin_File {
	public static void main(String[] args){
		Scanner input= new Scanner(System.in);
		String str;
		while(true){
			System.out.print("$ ");
			str= input.next();
			
			/*
			 * bash (Bourne Again Shell). bash is a command processor.
			 * runs in a text window
			 * where the user types command that cause action.
			 * 
			 */
			
			/*
			 * ProcessBuilder class is used to create Operating System process with 
			 * a collection of process attribute.
			 * start () method create a Process instance with these attribute. 
			 * 
			 * constructor:  ProcessBuilder("command","arg1","arg2");
			 * 
			 */
			
			// Make Directory
			

			if(str.equals("mkdir")){
				ProcessBuilder p;
				String MKDIR= input.next();
				p = new ProcessBuilder("bash","-c","mkdir "+MKDIR);
				try {
					p.start();
				} catch (IOException e) {
					
					e.printStackTrace();
				}
				
			}
			
			
			//Remove Directory
			else if(str.equals("rmdir")){
				ProcessBuilder p;
				String RMDIR= input.next();
				
				File f= new File(RMDIR);
				
				if(f.exists()){
				
				 p = new ProcessBuilder("bash","-c","rmdir "+RMDIR);
				try {
					p.start();
				} catch (IOException e) {
					
					e.printStackTrace();
				}
				}
				else {
					System.out.println("This file Does not Exists");
				}
				
			}
			
			//List Directory
			
			else if(str.equals("ls")){
				ProcessBuilder p  =new ProcessBuilder("bash","-c","ls");
					try {
						Process z= p.start();
						/*
						 * InputStreamReader class is a bridge from byte stream to
						 * character stream.It reads byte and decode them into characters.
						 */
						
						/*
						 * BufferedReader class reads text from a character-input stream.
						 * Buffering characters so as to provide for efficient reading of characters,arrays and lines.
						 */
						BufferedReader buffer= new BufferedReader(new InputStreamReader(z.getInputStream()));
						while((str= buffer.readLine())!=null){
							System.out.println(str);
						}
					} catch (IOException e) {
						e.printStackTrace();
					}

			}
			
			
			// Present Working Directory
			else if(str.equals("pwd")){
				ProcessBuilder p =new ProcessBuilder("bash","-c","pwd");
				try {
					Process z= p.start();
					BufferedReader buffer= new BufferedReader(new InputStreamReader(z.getInputStream()));
					while((str= buffer.readLine())!=null){
						System.out.println(str);
					}
				} catch (IOException e) {
					
					e.printStackTrace();
				}
			}
			else if(str.equals("cd")){
				ProcessBuilder p;
				String DIRECTORY= input.next();
				p = new ProcessBuilder("bash","-c","cd "+ DIRECTORY);
				try {
					p.start();
				} catch (IOException e) {
					
					e.printStackTrace();
				}
				
			}
			else {
				System.out.println("Invalid Command");
			}
		}
	}
}
