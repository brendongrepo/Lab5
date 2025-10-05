import java.util.Scanner;

/**
 * Prime:
 * 1) Asks the user to enter a whole number greater than 2 to test whether or not it's prime.
 * 2) Uses the testForPrime() method to determine if the number is prime or not.
 * 3) Displays whether the entered number is prime or not.
 * 4) Prompts the user to enter "yes" to test another number or "no" to quit.
 * 5) Continues looping until the user chooses to stop.
 * 
 * @author Brendon Grepo, bgrepo@student.sdccd.edu
 * @version v1.0
 * @since 10/5/2025
 */
public class Prime {
    public static void main (String[] args) {
        boolean isPrime;
        int number; 
        String playAgain; 
        do{ 
            System.out.print("Enter a whole number > 2 to test if prime: ");
            Scanner keyboard = new Scanner(System.in);
            number = keyboard.nextInt();
            isPrime = testForPrime(number);
            if (isPrime) {
                System.out.println(number + " is prime.");
            } else {
                System.out.println(number + " is not prime.");
            }
            
            System.out.print("Enter yes to test another number, no to quit: ");
            playAgain = keyboard.next();
        }while (playAgain.equalsIgnoreCase("yes")); 
    }//end main

    /**
     * Tests whether the given integer is prime.
     * @param inNumber the integer to test (should be > 2)
     * @return true if inNumber is prime; false otherwise
     */
    public static boolean testForPrime(int inNumber){
        int inNumberSqRt; 
        inNumberSqRt = (int)Math.sqrt(inNumber); 
        boolean isPrimeMeth = true; 

        for(int i=2;isPrimeMeth&&i<=inNumberSqRt;i++){  
           if (inNumber % i == 0) {
                isPrimeMeth = false; 
           } 
        }
        return isPrimeMeth;
    }//end testForPrime
}//end Prime