package com.practice.tavisca.eshop;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Customer {
	private int customerId;
	private String email;
	private String password;
	private Date date;
	private AtomicInteger counter = new AtomicInteger(0);

	private String EMAIL_PATTERN = "^[[A-Za-z0-9]+@[A-Za-z0-9]+(\\.[A-Za-z0-9-]+)]{7,20}$";
	private String PASSWORD_PATTERN = "((?=.*[*#$--]).{5,10})";
	private String MINDATE = "31 Dec 1995";
	private String MAXDATE = "1 Jan 1985";

	public Customer(String email, String password, Date date) throws Exception {
		super();
		this.validateEmail(email);
		this.validatePassword(password);
		this.validateDOB(date);
		this.customerId = counter.incrementAndGet();
		this.email = email;
		this.password = password;
		this.date = date;
	}

	private void validateEmail(String email) throws InvalidEmailException {
		Pattern pattern = Pattern.compile(EMAIL_PATTERN);
		Matcher matcher = pattern.matcher(email);
		boolean result = matcher.matches();
		if (!result) {
			throw new InvalidEmailException("Invalid Email");
		}

	}

	private void validatePassword(String password) throws InvalidPasswordException {
		Pattern pattern = Pattern.compile(PASSWORD_PATTERN);
		Matcher matcher = pattern.matcher(password);
		boolean result = matcher.matches();
		if (!result) {
			throw new InvalidPasswordException("Invalid Password.");
		}
	}

	private void validateDOB(Date dob) throws InvalidDOBException, ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("d MMM yyyy");
		Date maxDate = sdf.parse(MAXDATE);
		Date minDate = sdf.parse(MINDATE);

		if ((maxDate.compareTo(dob) > 0) && (minDate.compareTo(dob) < 0)) {
			throw new InvalidDOBException("Invalid DOB");
		}

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		return true;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
