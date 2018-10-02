package com.liferay.training.amf.registration.validator;

import com.liferay.portal.kernel.util.Validator;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegistrationValidator {

	// use for first and last name
	public static boolean isNameValid(String name) {
		boolean result = true;

		if (!(name.length() <= 50) && !Validator.isAlphanumericName(name)) {
			result = false;
		}

		return result;
	}

	public static boolean isEmailValid(String email) {
		boolean result = true;

		if (!(email.length() <= 255) && !Validator.isAlphanumericName(email)) {
			result = false;
		}

		return result;
	}

	// how to check if username is unique?
	public static boolean isUsernameValid(String username) {
		boolean result = true;

		if (!(username.length() >= 4) && !(username.length() <= 16) && !Validator.isAlphanumericName(username)) {
			result = false;
		}

		return result;
	}

	public static boolean isBirthdayValid(int year) {
		boolean result = true;

		if ((year >= 2005)) {
			result = false;
		}

		return result;
	}

	public static boolean isPasswordValid(String pw1, String pw2) {
		boolean result = true;

		Pattern pattern = Pattern.compile("[a-zA-Z0-9]*");
		Matcher matcher = pattern.matcher(pw1);

		if (pw1.length() < 6 && !Validator.isChar(pw1) && pw1.matches(".*\\d+.*") && matcher.matches()
				&& doesPasswordMatch(pw1, pw2)) {
			result = false;
		}

		return result;
	}

	public static boolean doesPasswordMatch(String pw1, String pw2) {
		boolean result = true;

		if (!pw1.equals(pw2)) {
			result = false;
		}

		return result;
	}

	// use this for both phone numbers
	public static boolean isPhoneNumberValid(String phone) {
		boolean result = true;

		if (phone.isEmpty()) {
			result = true;
		}else if (phone.length() != 10) {
			result = false;
		}

		return result;
	}

	// use this for, address1, address2, city, and security answer
	public static boolean isAddressValid(String address) {
		boolean result = true;

		if (!(address.length() >= 255) && !Validator.isAlphanumericName(address)) {
			result = false;
		}

		return result;
	}
	
	public static boolean isAddress2Valid(String address) {
		boolean result = true;

		if (address.isEmpty()) {
			result = true;
		}else if (!(address.length() >= 255) && !Validator.isAlphanumericName(address)) {
			result = false;
		}

		return result;
	}

	public static boolean isStateValid(long state) {
		boolean result = true;

		if (state < 19001 && state > 19052) {
			result = false;
		}

		return result;
	}

	public static boolean isZipValid(String zip) {
		boolean result = true;

		if (zip.length() != 5) {
			result = false;
		}

		return result;
	}

	public static boolean isSecurityQuestionValid(String question) {
		boolean result = true;

		if (Validator.isBlank(question)) {
			result = false;
		}

		return result;
	}

	public static boolean isTouValid(boolean tou) {
		boolean result = true;

		if (tou != true) {
			result = false;
		}

		return result;
	}

	public static ArrayList<String> isFormInfoValid(String firstname, String lastname, String email, String username,
			int dobYear, String pw1, String pw2, String homephone, String mobilephone, String addr1, String addr2,
			String city, String zip, String securityquestion, String answer, boolean tou, long state) {
		// boolean result = true;
		ArrayList<String> invalids = new ArrayList<>();

		if (!isNameValid(firstname)) {
			invalids.add("First Name is invalid.");
		} else if (!isNameValid(lastname)) {
			invalids.add("Last Name is invalid.");
		} else if (!isEmailValid(email)) {
			invalids.add("Email is invalid.");
		} else if (!isUsernameValid(username)) {
			invalids.add("Username is invalid.");
		} else if (!isBirthdayValid(dobYear)) {
			invalids.add("Birthday is invalid. Must be 13 to join.");
		} else if (!isPasswordValid(pw1, pw2)) {
			invalids.add("Password is invalid or does not match.");
		}else if (!isPhoneNumberValid(homephone)) {
			invalids.add("Home phone is invalid. Must be 10 digits.");
		}else if (!isPhoneNumberValid(mobilephone)) {
			invalids.add("Mobile phone is invalid. Must be 10 digits.");
		}else if (!isAddressValid(addr1)) {
			invalids.add("Address 1 is invalid.");
		}else if (!isAddress2Valid(addr2)) {
			invalids.add("Address 2 is invalid.");
		}else if (!isAddressValid(city)) {
			invalids.add("City is invalid.");
		}else if (!isStateValid(state)) {
			invalids.add("State is invalid. Please make sure to enter US state only.");
		}else if (!isZipValid(zip)) {
			invalids.add("Zip code is invalid. Must be 5 digits.");
		}else if (!isSecurityQuestionValid(securityquestion)) {
			invalids.add("Security Question must be selected.");
		}else if (!isAddressValid(answer))	{
			invalids.add("Answer is invalid. Must not be blank.");
		}else if (!isTouValid(tou)) {
			invalids.add("Must accept Terms of Service.");
		}

		return invalids;
	}
}
