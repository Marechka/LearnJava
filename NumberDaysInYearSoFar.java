// Author: Masha Fitzgerald
// 02/04/2021
// Homework #3 upload to git

/* Pseudocode
   1. Declair variables: int day, string month, int year
   2. Create object Scanner 
   3. Ask user to enter values for day, month and year
   4. Assigne user's input to our variables
   6. Calculate days since the begining  of the year, while taking into consideration if it's a leap year or not
    a) Evaluate if the entered year is a leap year by using if else 
      1.If the (year % 4 == 0) && (year % 100 !== 0) || (year % 400 == 0) - leap year = true (366 days)
      2.Else - year is NOT a leap yesr = false (365 days)
    b) Use Switch to evaluate day value of each month 
      1. If String.equals(Month) - September, April, June
            daysInMonth = 30;
        } else { 
            If String.equals(Month) - February  && year is leap - 
            daysInMonth = 29; 
           } else {
            daysInMonth = 28;
        } else {
         daysInMonth = 31; */



 /* while (month.matches(".*\\d+.*")) {
         System.out.print( "Try again. Enter a name of the month, for example, January "); 
         month = keyboard.nextLine();
      }    */       
         
import java.util.Scanner;      
 
public class NumberDaysInYearSoFar {
   public static void main (String [] args) {
      
      int dayOfMonth = 0;
      String month = "";
      int year = 0;
      
      Scanner keyboard = new Scanner(System.in);
   
      System.out.print( "What month is it? ");
      month = keyboard.nextLine();
   
      System.out.print( "What day of the month is it? ");
      dayOfMonth = keyboard.nextInt();
   
      System.out.print( "What year is it? ");
      year = keyboard.nextInt();
      
      boolean leapYear;
      
      if (( year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0))) {
         leapYear = true;
      } else {
         leapYear = false;
      }
      int nMonth = 0;
      int nDays = 31;
      if (nMonth == 1) {
         nDays = 0;
      }
      int daysSoFar = 0;
      int daysInYear = 0;
     
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
      if (leapYear == true) {
         if (nMonth >= 12) { ////|| (nMonth == 6) || (nMonth == 9)) {
            daysSoFar = (nMonth - 1) * nDays - 5; 
         } else if (nMonth >=10) {
            daysSoFar = (nMonth - 1) * nDays - 4;
         } else if (nMonth >=7) {
            daysSoFar = (nMonth - 1) * nDays - 3; 
         } else if (nMonth >= 5) {
            daysSoFar = (nMonth - 1) * nDays - 2;
         } else if (nMonth >=3) {
            daysSoFar = (nMonth - 1) * nDays - 1;
         } 
      } else {
         if (nMonth >= 12) {
            daysSoFar = (nMonth - 1) * nDays - 6; 
         } else if (nMonth >=10) {
            daysSoFar = (nMonth - 1) * nDays - 5;
         } else if (nMonth >=7) {
            daysSoFar = (nMonth - 1) * nDays - 4; 
         } else if (nMonth >= 5) {
            daysSoFar = (nMonth - 1) * nDays - 3;
         } else if (nMonth >=3) {
            daysSoFar = (nMonth - 1) * nDays - 2;
         } 
      }
      
      daysInYear = daysSoFar + dayOfMonth - 1;
      System.out.println(daysInYear);
      if ((daysInYear == 1) && (leapYear == true)) {
         System.out.print( "There is " + daysInYear + " complete day since the beginning of the leap year " + year);
      } else if ((daysInYear == 1) && (leapYear == false)) { 
         System.out.print("There is " + daysInYear + " complete day since the beginning of the non-leap year " + year);
      } else if ((daysInYear != 1) && (leapYear == true)) {
         System.out.print( "There are " + daysInYear + " complete days since the begining of the leap year " + year);
      } else {
         System.out.print( "There are " + daysInYear + " complete days since the begining of the non-leap year " + year);
      }
   }
}
  
  
  
  
  
  
 
            
            
