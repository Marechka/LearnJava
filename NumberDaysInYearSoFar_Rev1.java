// Author: Masha Fitzgerald
// Date: 02/04/2021
// Description: Homework #3

/* Pseudocode
   1. Declair variables: int day, string month, int year and boolean for leap year
   2. Create object Scanner 
   3. Ask user to enter value for a month (string)
   4. Validate if (month entry matches requirments) - move on, else - try again
   5. Ask user to enter year
   6. Evaluate if the entered year is a leap year by using if else 
      Steps:
    1. If the year is evenly divisible by 4, go to step 2. Otherwise, go to step 5.
    2. If the year is evenly divisible by 100, go to step 3. Othervise, go to step 4.
    3. If the year is evenly divisible by 400, go to step 4. Otherwise, go to step 5.
    4. The year is a leap year (366 days).
    5. The year is not a leap year (365 days).
    
      If the (year % 4 == 0) && (year % 100 !== 0) || (year % 400 == 0) - leap year = true (366 days)
      Else - year is NOT a leap year = false (365 days)

   7. Ask user to enter value for a day (int)
   8. Validate if (int > 31 || int <=0) - try again
   9. Calculate days since the begining  of the year, while taking into consideration if it's a leap year or not       
    a) Use Switch to assigne numerical value to the String month
    1. Declare variable int nMonth
    2. switch (month) {
         case "January" :
            nMonth = 1;
         break;
    b) Declare variables nDays (with value of 31 by default), daysSoFar (accumulated days of the passed complete months), daysInYear (total days in the year including current month)
    4. daysSoFar = (nMonth-1) * nDays
    5. Use if, else if to minus days from the months with value less than 31 day
         if (nMonth >= 3) { 
         daysSoFar -= 3    // 31 day - 28 days for February = 3
         Following months have 30 days: April, June, September, November
    c) If (leapYear == true) add 1 more day to the total after February (nMonth >=3)
    d) All days in  the year including current month 
        daysInYear = daysSoFar + dayOfMonth - 1 (not including current day)
    e) Printing out results considering if amount of days is plural or singular and if the entered year is leap or non leap
       if (leapYear == true) {
            if (daysInYear == 1) {
            System.out.print( "There is " + daysInYear + " complete day since the beginning of the leap year " + year);
            ...... */
            
            
   /* Input, which is breaking program:
   1. Any non digit entry for the question "What year is it?
   2. Any non digit entry for the question "What day is it? */ 

import java.util.Scanner;      
 
public class NumberDaysInYearSoFar_Rev1 {
   public static void main (String [] args) {
      
      // Declaring variables for the day of the month, month name, a year & leapYear
      String month = "";
      int dayOfMonth = 0;
      int year = 0;
      boolean leapYear;
      
      // Creating object Scanner
      Scanner keyboard = new Scanner(System.in);
      
      // Printing instructions for the user and assigning entered values to our variables 
      System.out.print( "What month is it? ");
      month = keyboard.nextLine();
      
      
      if ((month.equalsIgnoreCase("January")) || (month.equalsIgnoreCase("February")) || (month.equalsIgnoreCase("March")) ||
             (month.equalsIgnoreCase("April")) || (month.equalsIgnoreCase("May")) || (month.equalsIgnoreCase("June")) || 
            (month.equalsIgnoreCase("July")) || (month.equalsIgnoreCase("August")) || (month.equalsIgnoreCase("September")) || 
            (month.equalsIgnoreCase("October")) || (month.equalsIgnoreCase("November")) || (month.equalsIgnoreCase("December"))) {
         System.out.println( "Moving on :)"); 
      } else {
         System.out.print( "Try again. Enter a name of the month, for example, January "); 
         month = keyboard.nextLine();
      }
      
      System.out.print( "What year is it? ");
      year = keyboard.nextInt();
                
      // Checking if the entered year is leap or non leap year
      if (( year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0))) {
         leapYear = true;
      } else {
         leapYear = false;
      }
         
      
      System.out.print( "What day of the month is it? ");
      dayOfMonth = keyboard.nextInt();
      
      while ((dayOfMonth <= 0) || (dayOfMonth > 31) ||
            ((dayOfMonth > 28) && (month.equalsIgnoreCase("February")) && (leapYear == false)) || 
            ((dayOfMonth > 29) && (month.equalsIgnoreCase("February")) && (leapYear == true)) ||
            ((dayOfMonth > 30) && ((month.equalsIgnoreCase("April")) || (month.equalsIgnoreCase("June")) || 
                                    (month.equalsIgnoreCase("September")) || (month.equalsIgnoreCase("November")))))
      {
         System.out.print( "Please try again and enter a number 1-31 for a day of the month ");
         dayOfMonth = keyboard.nextInt();
      }
               
      // Declaring variables for the total number of days in the year so far 
      int nMonth = 0;
      int nDays = 31;
      int daysSoFar = 0;
      int daysInYear = 0;
     
      // Assigning numerical value to the string value of the month name
      switch (month) {
         case "January":
            nMonth = 1;
            break;
         case "February":
            nMonth = 2;
            break;
         case "March":
            nMonth = 3;
            break;
         case "April":
            nMonth = 4;
            break;
         case "May":
            nMonth = 5;
            break;
         case "June":
            nMonth = 6;
            break;
         case "July":
            nMonth = 7;
            break;
         case "August":
            nMonth = 8;
            break;
         case "September":
            nMonth = 9;
            break;
         case "October":
            nMonth = 10;
            break;
         case "November":
            nMonth = 11;
            break;
         case "December":
            nMonth = 12;
            break;
      }
      
     // Calculating accumulated number of days so far in the year based on the default 31 day assigned to each month
      daysSoFar = (nMonth - 1) * nDays;
      if (nMonth == 12) { 
         daysSoFar -= 7;          // November
      } else if (nMonth >=10) {
         daysSoFar -= 6;          // September
      } else if (nMonth >=7) {
         daysSoFar -= 5;          // June
      } else if (nMonth >= 5) {
         daysSoFar -= 4;          // April
      } else if (nMonth >=3) {
         daysSoFar -= 3;          // February 
      }
      
     // Additional day for leap year
      if ((leapYear == true) && (nMonth >= 3)) {    
         ++daysSoFar;
      }
      
     // Days in all previouse months + days of the current month
      daysInYear = daysSoFar + dayOfMonth - 1;
      System.out.println(daysInYear);
      
     // Printing result with consideration if it's a leap/ non-leap year, singular and plural amount of days
      if (leapYear == true) {
         if (daysInYear == 1) {
            System.out.print( "There is " + daysInYear + " complete day since the beginning of the leap year " + year);
         } else {
            System.out.print( "There are " + daysInYear + " complete days since the beginning of the leap year " + year);
         }
      } else {
         if (daysInYear == 1) {
            System.out.print("There is " + daysInYear + " complete day since the beginning of the non-leap year " + year);
         } else {
            System.out.print( "There are " + daysInYear + " complete days since the beginning of the non-leap year " + year);
         }
      }
   }
}
  
  
  
  
  
  
 
            
            
