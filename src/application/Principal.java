package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Reservation;

public class Principal {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Room Number: ");
		int roomNumber = sc.nextInt();
		System.out.print("Check-in date (dd/MM/yyyy): ");
		sc.nextLine();
		Date checkin = sdf.parse(sc.nextLine());
		System.out.print("Check-out date (dd/MM/yyyy): ");
		Date checkout = sdf.parse(sc.nextLine());
		
		if (!checkout.after(checkin)) {
			System.out.println("Error in reservation: Check-out date must be after check-in date");
		}
		else {
			Reservation res = new Reservation(roomNumber, checkin, checkout);
			System.out.println(res);
			
			
			System.out.println();
			System.out.println("Enter the data to update the reservation: ");
			System.out.print("Check-in date (dd/MM/yyyy): ");
			Date newCheckin = sdf.parse(sc.nextLine());
			System.out.print("Check-out date (dd/MM/yyyy): ");
			Date newCheckout = sdf.parse(sc.nextLine());
			
			Date now = new Date();
			if (newCheckin.before(now) || newCheckout.before(now)) {
				System.out.println("Error in reservation: Reservation dates for update must be future dates.");
			}
			else if (!newCheckout.after(newCheckin)) {
				System.out.println("Error in reservation: Check-out date must be after check-in date");
			}else {
				res.updateDates(newCheckin, newCheckout);
				System.out.println(res);
				
			}	
		}
		sc.close();

	}

}
