package Filehandling;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
public class file 
{
	    public static void main(String args[]) throws FileNotFoundException, IOException {
	        System.out.println("Welcome'Select an one operation U want' ");
	        System.out.println(" W for write ");
	        System.out.println(" R for read ");
	        System.out.println(" A for append ");
	        Scanner in =new Scanner(System.in);
	        String s=in.nextLine();
	        if(s.equalsIgnoreCase("R"))
	        {
	            new FReading();
	        }
	        else if(s.equalsIgnoreCase("W")||s.equalsIgnoreCase("A"))
	        {
	            writingToFile(s);
	        }
	        else
	        {
	            System.out.println("Error");
	        }
	        in.close();
	    }
	    public static void writingToFile(String s)
	    {
	        Scanner in=null;
	        try
	        {
	            String source = "";
	            File f=new File("file1.txt");
	            
	            BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
	            FileWriter f0 =null;
	            if(s.equalsIgnoreCase("W"))
	            {
	                f0 = new FileWriter(f,false);
	                System.out.println("content overwrite");
	                System.out.println("Type 'No' to exit");
	                System.out.println("want to proceed :type 'Yes' ");
	                in=new Scanner(System.in);
	                String s1=in.nextLine();
	                if(s1.equals("No"))
	                System.exit(0);
	                System.out.println("Write 'Stop' to finish ");
	                f.delete();
	                f.createNewFile();
	                while(!(source=bf.readLine()).equalsIgnoreCase("Stop")){
	                    f0.write(source + System.getProperty("line.separator"));
	                }
	                in.close();
	            }
	            else
	            {  f0 = new FileWriter(f,true);
	                System.out.println("Write 'Stop' to finish ");
	                while(!(source=bf.readLine()).equalsIgnoreCase("Stop")){
	                    f0.append(source+ System.getProperty("line.separator"));
	                }
	            }
	            f0.close();
	        }
	        catch(Exception e){
	            System.out.println("Error : " );
	            e.printStackTrace();
	        }
	    }    
	}
	class FReading {
	    public static String str="";
	    public FReading() 
	    {
	        try{
	            File f5=new File("file1.txt");
	            if(! f5.exists())
	            f5.createNewFile();
	            FileReader fl=new FileReader(f5);
	            BufferedReader bf=new BufferedReader(fl);
	            while((str=bf.readLine())!=null){
	                System.out.println(str);
	            }
	            fl.close();
	            }catch(Exception e){
	            System.out.println("Error : " );
	            e.printStackTrace();
	        }
	    }
	}
