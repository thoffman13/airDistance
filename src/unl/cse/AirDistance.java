package unl.cse;
 
import java.util.Scanner;

/**
 * Author: Trevor Hoffman
 *
 * Date: 2022/09/01
 *
 * This program prompts the user to enter
 * a latitude and longitude to compute the
 * total distance between the two locations
 * using the Spherical Law of Math.cosines
 * where the distance d is
 * d = arcMath.cos (sin(ϕ1) sin(ϕ2) + Math.cos(ϕ1) Math.cos(ϕ2) Math.cos(∆)) · R
 * ϕ1 is the latitude of location A, ϕ2 is the latitude of location B
 * ∆ is the difference between location B’s longitude and location A’s longitude
 * R is the (average) radius of the earth, 6,371 kilometers
 * Degrees (deg) will be converted to radians (r) using
 * r = (deg / 180) * PI
 *
 */


public class AirDistance {
		
	public static void main(String args[]) {

		final int R = 6371;
		
		double latLocationA, longLocationA, latLocationB, longLocationB;

		Scanner coordinates = new Scanner(System.in);
		
		System.out.printf ("Enter the latitude of the first location (in degrees): ");
		latLocationA = coordinates.nextDouble();

		if ((latLocationA < -90.0) || (latLocationA > 90.0)) {

		    System.err.printf("ERROR: enter a coordinate in the range [-90, 90] \n");
		    System.exit(1);

		}
		
		System.out.printf ("Enter the longitude of the first location (in degrees): ");
		longLocationA = coordinates.nextDouble();

		 if ((longLocationA < -180.0) || (longLocationA > 180)) {

		    System.err.printf("ERROR: enter a coordinate in the range [-180, 180]\n");
		    System.exit(1);

		}

		System.out.printf ("Enter the latitude of the second location (in degrees): ");
		latLocationB = coordinates.nextDouble();

		if ((latLocationB < -90.0) || (latLocationB > 90.0)) {

		    System.err.printf ("ERROR: enter a value in the range [-90, 90] \n");
		    System.exit (1);

		}

		System.out.printf ("Enter the longitude of the second location (in degrees): ");
		longLocationB = coordinates.nextDouble();

		 if ((longLocationB < -180.0) || (longLocationB > 180)) {

		    System.err.printf("ERROR: enter a coordinate in the range [-180, 180]\n");
		    System.exit(1);
		}

		double deg = latLocationA;

		double rOfLatA = (deg / 180) * Math.PI;

		deg = latLocationB;

		double rOfLatB = (deg / 180) * Math.PI;

		double longDifference = (longLocationB - longLocationA);

		deg = longDifference;

		double rOfDifference = (deg / 180) * Math.PI;

		double distance = Math.acos(Math.sin(rOfLatA) * Math.sin(rOfLatB) + Math.cos(rOfLatA) * Math.cos(rOfLatB) * Math.cos(rOfDifference)) * R;

		System.out.printf ("Location Difference \n\n");

		System.out.printf ("Starting Location: (%f, %f) \n", latLocationA, longLocationA);

		System.out.printf ("Ending Location:   (%f, %f) \n", latLocationB, longLocationB);

		System.out.printf ("Air distance is %f kms \n", distance);
	

	}
}


