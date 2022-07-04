import java.sql.Date;
import java.text.ParseException;
import java.util.Scanner;

import com.revature.raza.models.Customer;
import com.revature.raza.services.BankServiceImpl;

public class BankApplication {
	private static BankServiceImpl bankService = new BankServiceImpl(); 
	private static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		System.out.println("Welcome to our Commercial Bank");
		boolean isActive = true; 
		
		
		Customer customer = null; 
		while (isActive) {
			if (customer == null) {
				System.out.println("Choose one of the following options \n"
						+ "1. Sign in\n"
						+ "2. Sign up\n"
						+ "e. Exit");
				
				String input = scanner.nextLine(); 
				switch(input) {
				case "1": 
					customer = signIn(); 
					break; 
				case "2": 
					customer = signUp(); 
					break; 
				default: 
					isActive = false; 
					System.out.println("Thanks for visiting!");
				}
				
			}
			if (customer != null) {
				System.out.println("Welcome to our account services page. ");	
				isActive = false; 
			}
		
		}//outer while loop
	}

	private static Customer signIn() {
		boolean isSigning = true; 
		
		while (isSigning) {
			System.out.println("Enter your username: ");
			String username = scanner.nextLine(); 
			System.out.println("Enter your password");
			String passwd = scanner.nextLine(); 
			Customer customer = bankService.signIn(username, passwd); 
			
			if (customer == null) {
				System.out.println("No matching user. \n"
						+ "Try again? (y/n");
				String input = scanner.nextLine().toLowerCase(); 
				if(!input.equals("y")) {
					isSigning = false; 
				}
			}else {
				return customer; 
			}
		}
		return null; 
	}

	private static Customer signUp() throws ParseException {
		boolean isSigningUp = true; 
		Customer customer = null; 
		while (isSigningUp) {
			System.out.println("Enter your username: ");
			String username = scanner.nextLine(); 
			System.out.println("Enter your birth date (yyyy-mm-dd): ");
			String date = scanner.nextLine(); 
			Date birthDate = Date.valueOf(date);
			System.out.println("Enter your email: ");
			String email = scanner.nextLine(); 
			System.out.println("Enter your phone number: ");
			String phone = scanner.nextLine(); 
			System.out.println("Enter your password: ");
			String passwd = scanner.nextLine(); 
			
			customer = new Customer(1, username, birthDate, email, phone, passwd); 
			customer = bankService.signUp(customer); 
			
			if(customer == null) {
				System.out.println("Customer already exists. \n"
						+ "Try again? (y/n)");
				String input = scanner.nextLine().toLowerCase(); 
				if ("n".equals(input)) {
					isSigningUp = false; 
					return customer; 
				} 
			} else {
				System.out.println("Created successfully!");
				isSigningUp = false; 
			}
		}
		return customer; 
		
	}





















}







