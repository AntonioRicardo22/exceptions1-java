package application;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args)  {
		
		Scanner sc = new Scanner(System.in);
		
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		try {
			
			System.out.print("Room number: ");
			int number = sc.nextInt();
			System.out.print("Check-in date (dd/MM/yyyy): ");
			LocalDate checkIn = LocalDate.parse(sc.next(), format);
			System.out.print("Check-out date (dd/MM/yyyy): ");
			LocalDate checkOut = LocalDate.parse(sc.next(), format);
			
			Reservation reservation = new  Reservation (number,checkIn,checkOut);
			System.out.println("Reservation: " + reservation);
				
			System.out.println();
			System.out.println("Enter data to update the reservation: ");
				
			System.out.print("Check-in UPdate (dd/MM/yyyy): ");
			checkIn = LocalDate.parse(sc.next(), format);
			System.out.print("Check-out UPdate (dd/MM/yyyy): ");
			checkOut = LocalDate.parse(sc.next(), format);
				
				
			reservation.upDates(checkIn, checkOut);
			System.out.println("Reservation: " + reservation); 
		}
		
		catch(DomainException e) {
			System.out.println("Erro in reservation: " + e.getMessage());
		}
		
		catch (java.util.InputMismatchException e) {
            System.out.println("Erro: Você deve digitar um número inteiro.");
        }
		
		catch (java.time.format.DateTimeParseException e ) {
			System.out.println("Você deve informar uma data!");
		}
		catch (RuntimeException e ) {
			System.out.println("unexpected error");
		}
		
		//
		sc.close();

	}	

}
