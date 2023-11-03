package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;

public class Principal {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			System.out.print("Room Number: ");
			int roomNumber = sc.nextInt();
			System.out.print("Check-in date (dd/MM/yyyy): ");
			sc.nextLine();
			Date checkin = sdf.parse(sc.nextLine());
			System.out.print("Check-out date (dd/MM/yyyy): ");
			Date checkout = sdf.parse(sc.nextLine());
			
			
			Reservation res = new Reservation(roomNumber, checkin, checkout);
			System.out.println(res);
			
			
			System.out.println();
			System.out.println("Enter the data to update the reservation: ");
			System.out.print("Check-in date (dd/MM/yyyy): ");
			Date newCheckin = sdf.parse(sc.nextLine());
			System.out.print("Check-out date (dd/MM/yyyy): ");
			Date newCheckout = sdf.parse(sc.nextLine());
			
			res.updateDates(newCheckin, newCheckout);
			System.out.println(res);
		}
		catch(ParseException e) {
				System.out.println("Invalid data format");
		}
		catch(DomainException e) {
			System.out.println("Error in reservation: " + e.getMessage());
		}
		catch(RuntimeException e) {
			System.out.println("Unexpected error");
		}
			
		
		sc.close();

	}

}
