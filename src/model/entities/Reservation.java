package model.entities;

	
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import model.exceptions.DomainException;

	public class Reservation {

			
			private Integer roomNumber;
			private LocalDate checkIn;
			private LocalDate checkOut;
			
			static DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			
			Reservation(){}

			public Reservation(Integer roomNumber, LocalDate checkin, LocalDate checkout)  {
				 if  (!checkout.isAfter(checkin)) {	
					 throw new DomainException("Error in reservation: Check-out must be after check-in date: ");
				}
				this.roomNumber = roomNumber;
				this.checkIn = checkin;
				this.checkOut = checkout;
			}

			public Integer getRoomNumber() {
				return roomNumber;
			}

			public void setRoomNumber(Integer roomNumber) {
				this.roomNumber = roomNumber;
			}

			public LocalDate getCheckin() {
				return checkIn;
			}

			public LocalDate getCheckout() {
				return checkOut;
			}
			
			public void upDates (LocalDate checkin, LocalDate checkout) {
				LocalDate now = LocalDate.now();
				 
				 if (checkin.isBefore(now) || checkout.isBefore(now)) {
					throw new DomainException("reservation dates ffor update must be future dates");
				 
				 }
				 if  (checkout.isAfter(checkin)) {	
					 throw new DomainException("Error in reservation: Check-out must be after check-in date: ");
				}
				 
				this.checkIn = checkin;
				this.checkOut = checkout;	
				
			}
			
			public long duaration() {	
				 long duration = getCheckin().until(getCheckout(), ChronoUnit.DAYS);	
				 return duration;
			}
			
			@Override
			public String toString () {
				return "Room " 
			+ getRoomNumber() 
			+ ", Chcek-in: " 
			+ getCheckin().format(format) 
			+ ", Check-Out: " 
			+ getCheckout().format(format) 
			+ ", " + duaration() 
			+ " nights. ";
			}
		}



