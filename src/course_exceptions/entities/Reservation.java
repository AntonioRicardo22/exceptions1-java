package course_exceptions.entities;

	
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

	public class Reservation {

			
			private Integer roomNumber;
			private LocalDate checkin;
			private LocalDate checkout;
			
			static DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			
			Reservation(){}

			public Reservation(Integer roomNumber, LocalDate checkin, LocalDate checkout) {
				this.roomNumber = roomNumber;
				this.checkin = checkin;
				this.checkout = checkout;
			}

			public Integer getRoomNumber() {
				return roomNumber;
			}

			public void setRoomNumber(Integer roomNumber) {
				this.roomNumber = roomNumber;
			}

			public LocalDate getCheckin() {
				return checkin;
			}

			public LocalDate getCheckout() {
				return checkout;
			}
			
			public void upDates (LocalDate checkin, LocalDate checkout) {
				this.checkin = checkin;
				this.checkout = checkout;	
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



