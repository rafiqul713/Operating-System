package usingJavaAPI;

import java.io.File;
import java.util.Scanner;
/*
	Rafiqul Islam
	
*/
public class Using_JAVA_File_API {
    public static void main(String[] args){
        String command, str;
        Scanner input = new Scanner(System.in);
        
        while(true){
            System.out.print("$ ");
            command= input.next();
            
            // Make Directory 
            if(command.equals("mkdir")){
                str= input.next();
                 File f= new File(str);
                 f.mkdir();
                 System.out.println("Directory Created");
                
            }
            
            // List Directory
            else if(command.equals("ls")){
                String s;
                File fff= new File(".");
                 //Retrieve the Current location
                 s= fff.getAbsolutePath();
                 File LS = new File(s+"//.");
                getAllFile(LS);
                // send the current location, and print
                // the name of folder which are existing. 
            }
            
            // Remove Directory
            
            else if(command.equals("rmdir")){
              str = input.next();
              File file = new File(str);
              if (file.exists())
              {
                  file.delete();
                  System.out.println("File Deleted");
              }
              else {
                  System.out.println("File Does not Exists");
              }
            
            }
            
           
            // change Directory
            else if(command.equals("cd")){
                File file=new File(".");
                  System.out.println("Current  Directory: " + file.getAbsolutePath());
                  str= input.next();       
                  /*
                   * The System class maintains a Properties object that describes
                   * the configuration of the current working environment. 
                   * System properties include information about the current user, the current
                   * version of the Java runtime,
                   * and the character used to separate components of a file path name.
                   */
                  
                  
                  //To modify the existing set of system properties, use System.setProperties. This
                  //method takes a Properties object that has been initialized to contain
                  //the properties to be set.
                  System.setProperty("user.dir",str);
                  System.out.println("New Current  Directory: " + file.getAbsolutePath());
            }
            
            
            //Print Working Directory
            else if(command.equals("pwd")){
                
                //The getProperty method returns a string containing the value of the property.
                //If the property does not exist, this version of getProperty returns null.
                System.out.println(System.getProperty("user.dir"));
            }
            else {
                System.out.println("Invalid Command");
            }
            
            
        }
    }
    
     private static void getAllFile(File LS) {
      
      // all the name of file and folder is save in array.
      File[] filesList = LS.listFiles();
      if(LS.list().length>0){
      //if, folder then print the name of that folder
      for(File f : filesList){
          if(f.isDirectory())
              System.out.println(f.getName());
      
          }

        }
      else{
    	  System.out.println("The Folder is Empty");
      }
     }

}
