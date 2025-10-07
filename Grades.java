import java.util.Scanner;
import java.io.*;  

/**
 * Grades:
 * 1) Asks the user for the input and output file names.
 * 2) Reads each line of the input file, where each line contains a set of integer grades ending with the sentinel value -1.
 * 3) For each set of grades, calculates the number of As, Bs, Cs, Ds, and Fs.
 * 4) Determines the highest score, lowest score, and the average grade.
 * 5) Writes the results to the specified output file, labeling each set.
 * 6) Displays confirmation messages to the console once processing is complete.
 * 
 * @author Brendon Grepo, bgrepo@student.sdccd.edu
 * @version v1.1
 * @since 10/6/2025
 */
public class Grades {
    public static void main (String[] args) throws IOException{ 
        String inFile, outFile; 
        inFile = getInFile(); 
        outFile = getOutFile(); 
        processFile(inFile, outFile); 
    }//end main

    /**
     * Uses Scanner to get and return input file name
     * @return name of file from Scanner
     */
    public static String getInFile(){
        String inName; 
        Scanner kb = new Scanner(System.in);   
        System.out.print("Enter the name of the input file (ie input.txt): ");
        inName = kb.nextLine(); 
        File inFile = new File(inName); 
        
        while (!inFile.exists()){
            System.out.print("File not found. Enter the name of the input file (e.g., input.txt): ");
            inName = kb.nextLine();
            inFile = new File(inName);
        }
        return inName;
    }
    /**
     * Uses Scanner to get and return output file name
     * @return name of output file from Scanner
     */
    public static String getOutFile(){
        Scanner kb = new Scanner(System.in);
        System.out.print("Enter the name of the output file to create (ie output.txt): "); 
        return kb.nextLine();
    }
        
    /**
     * Processes an input grade file line by line, computing counts of letter grades,
     * min, max, and average for each set (terminated by -1), and writes results
     * to the specified output file.
     * @param inFileName  the path/name of the input file to read
     * @param outFileName the path/name of the output file to write
     */    
    public static void processFile(String inFileName, String outFileName) throws IOException{
        ////vars section
        int number;
        int As=0, Bs=0, Cs=0, Ds=0, Fs=0, min=0, max=0;
        int total=0, count=0;     
        double avg=0.0;
        int set=1;

        ////Scanner and PrintWriter streams section
        File inFile = new File(inFileName);
        Scanner in = new Scanner(inFile);
        PrintWriter out = new PrintWriter(outFileName);

        while (in.hasNextLine()){
            As=Bs=Cs=Ds=Fs=count=0;
            avg=0.0;
            total=0;

            String line = in.nextLine();
            Scanner lineScan = new Scanner(line);

            number = lineScan.nextInt();
            min = max = number;

            while (number != -1){
                if(number<min)
                    min = number;
                if(number>max)
                    max = number;
                count++;
                total += number;
                if(number>=90)
                    As++;
                else if (number>=80)
                    Bs++;
                else if (number>=70)
                    Cs++;
                else if (number>=60)
                    Ds++;
                else
                    Fs++;

                number = lineScan.nextInt();
            }//end while
            out.println("Set " + set + " of grades calculated");
            set++;
            if (count == 0){
                out.println("No grades to average");
            } else{
                out.println("Number of As: " + As);
                out.println("Number of Bs: " + Bs);
                out.println("Number of Cs: " + Cs);
                out.println("Number of Ds: " + Ds);
                out.println("Number of Fs: " + Fs);
                out.println("The high score was: " + max);
                out.println("The low score was: " + min);
                avg = (double) total / count;
                out.printf("The avg score is: %.1f%n", avg);
            }//end else
            out.println();
            lineScan.close();
        }//end while for each line
        System.out.println("Grade processing is completed");
        System.out.println("You can retrieve the output file at: " + outFileName);
        in.close();
        out.close();
    }//end processFile()
}//end Grades class