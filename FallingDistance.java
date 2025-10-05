import java.util.Scanner;

/**
 * FallingDistance:
 * 1) Calculates and displays the distance an object falls in each second of free fall up to the number of seconds entered by the user.
 * 2) Uses the getDistance() method to compute distance using the formula.
 * 3) Displays a formatted table showing seconds and corresponding distances.
 * 
 * @author Brendon Grepo, bgrepo@student.sdccd.edu
 * @version v1.0
 * @since 10/4/2025
 */

public class FallingDistance{
    //public constant for acceleration
    public static final double ACCELERATION = 9.8;  
    public static void main (String[] args) {
        Scanner keyboard = new Scanner(System.in);
        double distance;
        int numOfSecs;

        System.out.print("Please enter how many seconds to compute: ");
        numOfSecs = keyboard.nextInt();

        System.out.println("\nTime(secs)\tDistance(m)");
        System.out.println("==========\t============");
        for (int second = 1; second <= numOfSecs; second++) {
            distance = getDistance(second);
            System.out.printf("%d\t\t%.1f\n", second, distance);
        }
    } //end main
    /**
     * Calculates and returns the distance an object falls in a given time.
     *
     * @param seconds the number of seconds the object has been falling
     * @return the distance in meters that the object has fallen
     */
    public static double getDistance(int seconds) {
        return 0.5 * ACCELERATION * Math.pow(seconds, 2);
    }
}//end class