package course_exceptions.application;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import course_exceptions.entities.Reservation;

public class Program {

	public static void main(String[] args)  {
		
		Scanner sc = new Scanner(System.in);
		
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		
		System.out.print("Room number: ");
		int number = sc.nextInt();
		System.out.print("Check-in date (dd/MM/yyyy): ");
		LocalDate checkIn = LocalDate.parse(sc.next(), format);
		System.out.print("Check-out date (dd/MM/yyyy): ");
		LocalDate checkOut = LocalDate.parse(sc.next(), format);
		
		if (!checkOut.isAfter(checkIn)) {
			
			System.out.println("Error in reservation: Cehck-out must be after check-in date: ");
		}
		
		else {
			
			Reservation reservation = new  Reservation (number,checkIn,checkOut);
			System.out.println("Reservation: " + reservation);
			
			System.out.println();
			System.out.println("Enter data to update the reservation: ");
			
			 System.out.print("Check-in UPdate (dd/MM/yyyy): ");
			 checkIn = LocalDate.parse(sc.next(), format);
			 System.out.print("Check-out UPdate (dd/MM/yyyy): ");
			 checkOut = LocalDate.parse(sc.next(), format);
			
			
			String error =  reservation.upDates(checkIn, checkOut);
			
			if (error != null ) {
				System.out.println(error);
					}
			else {
			System.out.println("Reservation: " + reservation); 
			}	
		}
		
		sc.close();

	}	

}
