package myFirstProgram;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Main {
	  public static void main(String[] args) {
		  try {
				// initializing input and result variable
			  	File aoc = new File("C:\\Users\\JOSE\\Downloads\\aocDayFour.txt");
			    Scanner sc = new Scanner(aoc);
			    int sum = 0;
			    // reads each input line, calculates the points from the card, increments sum by that amount
			    for (int a = 0; a < 202; a++) {
			    	sum += pointCalculator(sc.nextLine());
			    }
			   
			    System.out.print(sum);
			    sc.close();
			   
		  } catch (FileNotFoundException e) {
			  e.printStackTrace();
		  }
	  }
	 
	  public static int pointCalculator(String card) {
		  // initializing variables
		  int matches = 0;
		  int points = 0;
		  // removes the "Card    x:" from each lines of input
		  String[] numbers = card.substring(10).split("\\|");
		  // isolates given numbers from the said card's winning numbers
		  String[] givenString = numbers[0].trim().split("\\s+");
		  String[] winningString = numbers[1].trim().split("\\s+");
		  // initializing integer arrays containing the said card's winning and given numbers
		  int[] givenNumbers = new int[10];
		  int[] winningNumbers = new int[25];
		
		  // parsing string arrays into integer arrays
		  for (int i = 0; i < 10; i++) {
			  givenNumbers[i] = Integer.parseInt(givenString[i]);
		  }
		  for (int i = 0; i < 25; i++) {
			  winningNumbers[i] = Integer.parseInt(winningString[i]);
		  }
		 
		  // searches for the amount of matches in the given card
		  for (int j : givenNumbers) {
			  for (int i : winningNumbers) {
				  if (j == i) {
					  matches += 1;
				  }
			  }
		  }
		 
		  // calculation of total points from the card. if there is more than one match, the following matches give 2 points.
		  matches = (int)matches;
		  switch (matches) {
		  case 0:
			  points = 0;
			  break;
		  case 1:
			  points = 1;
			  break;
		  default:
			  points = (int)Math.pow(2, (matches-1));
			  break;
		  }
		 
		  return points;
	  }
}
