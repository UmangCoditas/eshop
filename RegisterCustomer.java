package com.practice.tavisca.eshop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import com.practice.tavisca.eshop.Customer;

public class RegisterCustomer {

	public static void main(String[] args) throws IOException, ParseException {
		@SuppressWarnings("unused")
		Customer customer;
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter email");
		String email = reader.readLine();
		System.out.println("Enter password");
		String password = reader.readLine();
		System.out.println("Enter Date of Birth in this format like  1 Jan 1985");

		// 1 Jan 1985
		String inputDob = reader.readLine();
		SimpleDateFormat formatter = new SimpleDateFormat("d MMM yyyy");
		Date dob = formatter.parse(inputDob);
		
		try {
			customer = new Customer(email, password, dob);
			System.out.println("Customer registered successfully.");
			System.out.println("Customer Id is "+customer.getCustomerId()+" and email is "+customer.getEmail());
		} catch (InvalidEmailException e) {
			System.out.println("Email must contain : @ character, min length 7 , max length 20");
			System.out.println("Customer could not be registered.");
		} catch (InvalidPasswordException e) {
			System.out.println("Password must have min length of 5, max length of 10, should contain either -- * or $ or #");
			System.out.println("Customer could not be registered.");
		} catch (InvalidDOBException e) {
			System.out.println("Customer's DOB : Between 1st Jan 1985- 31st Dec 1995");
			System.out.println("Customer could not be registered.");
		} catch (Exception e) {
			System.out.println("Error occured. Please contact your system admin.");
		}

	}

}
