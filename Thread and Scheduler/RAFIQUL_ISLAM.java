package Assignment3;

/*
 * RAFIQUL ISLAM
 * 
 * 
 */


import java.util.*;
import java.io.*;


// Thread1 will Read all number from the file and Check Prime  
class Thread1 implements Runnable{
    int indx1;
    Scanner in;
    int[] arr1 = new int[2000];
    String[] s1= new String[2000];
    
    WriteInFile ob1= new WriteInFile();
    void setup(){
        try {
         in= new Scanner(new File(SharedClass.path));
        } catch (FileNotFoundException ex) {
          
        }
    }
    
    public void run(){
       
       this.setup();
       
      if(SharedClass.m_status[0]==1){
       indx1=0;
       // Read all number from the file
       while(in.hasNext())
       {
            String s= in.next();
            int N= Integer.parseInt(s);
            arr1[indx1++]=N;
           
       }
    
        
        
        // Check All number.  Prime or Not Prime
        for(int i=0;i<1000;i++){
            try {
                int SQRT= (int) Math.sqrt(arr1[i]);
                if(SharedClass.isprime(2, SQRT,arr1[i])==true)
                {
                    System.out.println(arr1[i]+" Prime Number");
                    s1[i]= "Prime ";
                }
                else 
                {
                   System.out.println(arr1[i]+ " is not Prime Number");
                   s1[i]= "Not Prime ";
                }
                
            } catch (Exception e) {
               
            }
            
            
           

        }
        
        //Write all result in the text file
        ob1.writeInFile(arr1,SharedClass.path1,1000,s1);
        
    
      }
      else{
           try {
               Thread.sleep(1000);
           } catch (InterruptedException ex) {
             
           }
      }
       
    
        System.out.println("Thread1 finished ");
    
    
    }
}


// Read Five number from the file and Check Prime
class Thread2 implements Runnable{
    WriteInFile ob2= new WriteInFile();
    Scanner in;
    String[] s2=new String[2000];
    int[] arr2 = new int[2000];
    int indx2=0;
      public void setup(){
        try {
            in = new Scanner(new File(SharedClass.path));
        } 
        catch (FileNotFoundException ex) {
        
        }
       
        }
       
      public void run(){
       
        this.setup();
        if(SharedClass.m_status[1]==1){
         for(int j=0;j<1000;j=j+5)
        {
            indx2=0;
    
            // Read five number from the file
              try {
                  for(int i=j; ( i< (j+5)) && (in.hasNext()) ; i++)
                 
                  {
                      try {
                          
                          String s= in.next();
                          int N= Integer.parseInt(s);
                          arr2[indx2++] =N;
                        
                      } 
                      catch (Exception e) {
                          
                      }
                 }
                  
               
                  
                  /*
                   * 
                   * Write 5 number into text file
                   * 
                   */
                  
                      
                  for(int i=0;i<5;i++)
                  
                  {
                     try {
                         int SQRT= (int) Math.sqrt(arr2[i]);
                         if(SharedClass.isprime(2, SQRT,arr2[i])==true)
                         {
                             System.out.println(arr2[i]+" Prime Number");
                             s2[i]= "Prime ";
                         }
                         else 
                         {
                            System.out.println(arr2[i]+ " is not Prime Number");
                             s2[i]= "Not Prime ";
                         }
                         
                     } 
                     catch (Exception ex)
                     {
                        
                     }
                     
                    
                     
                  }
                  ob2.writeInFile(arr2,SharedClass.path2, 5, s2);
                 
    
                  
                  /**/
                  
                
              
              } catch (Exception e) {
                  
              }
         
        }
        }
        else{
              try {
                  Thread.sleep(1000);
                  //wait();
              } catch (InterruptedException ex) {
                  
              }
        }
       
            System.out.println("Thread2 finished");
      

      }
    }


// Read one by one number from the file and check prime
class Thread3 implements Runnable{
    WriteInFile ob3= new WriteInFile();
    Scanner in;
    int[] arr3 = new int[2000];
    String[] s3 = new String[2000];
    int indx3;
      public void setup(){
        try {
            in = new Scanner(new File(SharedClass.path));
        } 
        catch (FileNotFoundException ex) {
        
        }
       
        }
    
    public void run(){
       
          this.setup();
          if(SharedClass.m_status[2]==1){
         for(int j=0;j<1000;j++)
        {
            indx3=0;
    
            // Read one number from the file
              try {
                  for(int i=j; ( i< (j+1)) && (in.hasNext()) ; i++)
                 
                  {
                      try {
                          
                          String s= in.next();
                          int N= Integer.parseInt(s);
                          arr3[indx3++] =N;
                        
                      } 
                      catch (Exception e) {
                          
                      }
                 }
                  
                  
                  /*
                   * Write one number into text file
                   * 
                   */
                  
                      
                  for(int i=0;i<1;i++)
                  
                  {
                     try {
                         int SQRT= (int) Math.sqrt(arr3[i]);
                         if(SharedClass.isprime(2, SQRT,arr3[i])==true)
                         {
                             System.out.println(arr3[i]+" Prime Number");
                             s3[i]= "Prime ";
                         }
                         else 
                         {
                            System.out.println(arr3[i]+ " is not Prime Number");
                             s3[i]= "Not Prime ";
                         }
                            ob3.writeInFile(arr3,SharedClass.path3, 1, s3);
                           
               
                        
                     } 
                     catch (Exception e)
                     {
                        
                     }
                     
                  }
                  
              
              } catch (Exception e) {
                  
              }
         
    }
          }
          else{
             try {
                 Thread.sleep(1000);
              
                 
             } catch (InterruptedException ex) {
                
             }
          }
          System.out.println("Thread3 finished ");


    }
}





class WriteInFile{
    
    
    // This method is used for writing number in text file
    void writeInFile(int[] value, String path, int Num,String[] result){
        try {
            Writer w= new FileWriter(path,true);
            PrintWriter p= new PrintWriter(w);
            for(int i=0;i<Num; i++)
            {
                String str= new Integer(value[i]).toString();
                w.write(str+"---->"+result[i]);
                //new line .txt file 
                p.println();
            }
            w.close();
        } 
        catch (IOException ex) {
           
        }
    }
}


// SharedClass is share among all Thread.
class SharedClass{
 static int[] m_status= new int[4];
 static int turn;
  static void init(){
      for(int i=0;i<=3;i++)
      {
          m_status[i]=0;
      }
      
       turn = 0;
     
  }
  
 
  
  
  static int[] arr= new int[2000];
  
  
  
// set File Name 
  static String path="randomNumber.txt";
  static String path1= "ThreadOneOutput.txt";
  static String path2= "ThreadTwoOutput.txt";
  static String path3= "ThreadThreeOutput.txt";
  
  
  // Method for Checking Prime Number
  static boolean isprime(int i, int rt, int n)
{
   if(n < 2) return false;
   if(i > rt) return true;
   if(n%i==0) return false;
   return isprime(i+1, rt, n);
}

}



class Scheduler implements Runnable{
        Thread1 t1= new Thread1();
        Thread2 t2= new Thread2();
        Thread3 t3= new Thread3();
        Thread t = new Thread(t1);
        Thread tt = new Thread(t2);
        Thread ttt = new Thread(t3);
  
        public void run(){      
            SharedClass.init();
            for(int Turn = 0;Turn<=3;Turn++)
            {
                if(Turn==0){
                    SharedClass.m_status[0]=0;
                    SharedClass.m_status[1]=0;
                    SharedClass.m_status[2]=0;
        
                }
                
                if(Turn==1){
                    SharedClass.m_status[0]=1;
                    t.start();
                }
                else if(Turn==2){
                    SharedClass.m_status[1]=1;
                    tt.start();
                }
                else if(Turn==3){
                    SharedClass.m_status[2]=1;
                    ttt.start();
                }
            }
        
    }
}

public class RAFIQUL_ISLAM {
    
public static void main(String[] args){
     int indx=0;
     Random gen = new Random();
    
     
     // Generate Random Number and store in a text file
        try{
         Writer writer=new FileWriter(SharedClass.path);
         PrintWriter print= new PrintWriter(writer);
   
    
        for(int i=1;i<=1000;i++)
        {
        String str= (new Integer(gen.nextInt(1000)).toString());
        writer.write(str+" ");
        print.println();
        
        }
        
        writer.close();
        
        }
        catch(Exception e)
        {
            
        }
        
        
        
        Scheduler schedule= new Scheduler();
        Thread s= new Thread(schedule);
        s.start();
       
        
        
       }    
        
}

