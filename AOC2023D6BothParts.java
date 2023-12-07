package myFirstProgram;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
	  public static void main(String[] args) {
		  try {
			  	File aoc = new File("C:\\Users\\JOSE\\Downloads\\aoc2023.txt");
			    Scanner sc = new Scanner(aoc);
			    //initializing and parsing input
			    String[] stringTimes = sc.nextLine().replaceAll("Time:", "").trim().split("\\s+");
			    String[] stringDistances = sc.nextLine().replaceAll("Distance:", "").trim().split("\\s+");
			    int[] times = new int[stringTimes.length];
			    int[] distances = new int[stringDistances.length];
			    int result = 0;
			    String finalTime = new String();
			    String finalDistance = new String();
			    long finalResult = 0;
			    //assigning int values to int arrays from the string arrays that were taken from the input
			    for (int i = 0; i < times.length; i++) {
			    	times[i] = Integer.parseInt(stringTimes[i]);
			    	distances[i] = Integer.parseInt(stringDistances[i]);
			    }
			    //going through each time-distance pair
			    for (int i = 0; i < times.length; i++) {
			    	if (result == 0) {
			    		result += waysToWin(times[i], distances[i]);
			    	} else {
			    		result *= waysToWin(times[i], distances[i]);
			    	}
			    }
			    //concatenating input for Part 2
			    for (int i = 0; i < times.length; i++) {
			    	finalTime = finalTime + stringTimes[i];
			    	finalDistance = finalDistance + stringDistances[i];
			    }
			    //parsing for Part 2
			    long parsedFinalTime = Long.parseLong(finalTime);
			    long parsedFinalDistance = Long.parseLong(finalDistance);
			    //answer for Part 2
			    finalResult = waysToWinLong(parsedFinalTime, parsedFinalDistance);
			   
			    System.out.print("The answer for Part 1 is: " + result + "\n" + "The answer for Part Two is: " + finalResult);
			    sc.close();
			    
		  } catch (FileNotFoundException e) {
			  e.printStackTrace();
		  }

	  }
	  //method for calculating the ways to win for each time-distance pair
	  public static int waysToWin(int currentTime, int currentDistance) {
		  int waysOfWinning = 0;
		  int timeHeld = 0;
		  int distance = 0;
		  
		  for (int i = 0; i < currentTime; i++) {
			  timeHeld = i;
			  if (timeHeld > 0) {
				  distance = timeHeld * (currentTime-timeHeld);
				  if (distance > currentDistance) {
					  waysOfWinning++;
				  }
			  }
			  
			  
		  }
		  
		  return waysOfWinning;
	  }
	  //same method as above but had to use longs as the time and distance values for Part 2 were l(ooooo)ong
	  public static long waysToWinLong(long currentTime, long currentDistance) {
		  long waysOfWinning = 0;
		  long timeHeld = 0;
		  long distance = 0;
		  
		  for (int i = 0; i < currentTime; i++) {
			  timeHeld = i;
			  if (timeHeld > 0) {
				  distance = timeHeld * (currentTime-timeHeld);
				  if (distance > currentDistance) {
					  waysOfWinning++;
				  }
			  }
			  
			  
		  }
		  
		  return waysOfWinning;
	  }
}
