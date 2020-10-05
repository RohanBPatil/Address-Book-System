package AddressBookMain;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddressBook {
	public String name;
	public List <Person> personList;
	public AddressBook(String name) {
		personList = new ArrayList<Person>();
		this.name = name;
	}
	
	public AddressBook() {
		personList = new ArrayList<Person>();
	}
	
	public void displayAllContacts() {
		System.out.println("DISPLAYING ALL CONTACT DETAILS FROM ADDRESS BOOK");
		for(int i = 0; i < personList.size(); i++) {
			System.out.println(personList.get(i));
		}
	}
	
	
	public void addPersonDetails() {
		Scanner scanner = new Scanner(System.in);
		
		String checkToAdd = "y";
		
		while(checkToAdd.equalsIgnoreCase("y")) {
			//variables
			String firstName;
			String lastName;
			String address;
			String state;
			int zip;
			long  phoneNum;
			String email;
			
			System.out.println("Enter following details : ");
			System.out.println("First Name : ");
			firstName = scanner.nextLine();
			System.out.println("Last Name : ");
			lastName = scanner.nextLine();
			System.out.println("Address : ");
			address = scanner.nextLine();
			System.out.println("City : "+name);
			System.out.println("State : ");
			state = scanner.nextLine();
			System.out.println("ZIP : ");
			zip = scanner.nextInt();
			System.out.println("Phone number : ");
			phoneNum = scanner.nextLong();
			scanner.nextLine();
			System.out.println("Email ID : ");
			email = scanner.nextLine();
			
			Person new_person = new Person(firstName, lastName, address, name, state, zip, phoneNum, email);
			personList.add(new_person);
			
			System.out.println("Enter 'y' to ADD NEW PERSON'S DETAILS.\nEnter any other key to STOP ADDING.");
			checkToAdd = scanner.nextLine();
		}
		
	}
	
	public void editPersonDetails() {
		String FirstName;
		String LastName;
		String address;
		int zip;
		long  phoneNum;
		String email;
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter name of a person to edit contact details");
		System.out.println("First Name : ");
		FirstName = scanner.nextLine();
		System.out.println("Last Name : ");
		LastName = scanner.nextLine();
		
		for(Person thatPerson : personList) {
			if(FirstName.equalsIgnoreCase(thatPerson.getFirstName()) && LastName.equalsIgnoreCase(thatPerson.getLastName())) {
				System.out.println("New Address : ");
				address = scanner.nextLine();
				thatPerson.setAddress(address);
				System.out.println("City : "+name);
				System.out.println("State : "+thatPerson.getState());
				System.out.println("New ZIP : ");
				zip = scanner.nextInt();
				thatPerson.setZip(zip);
				System.out.println("New Phone number : ");
				phoneNum = scanner.nextLong();
				thatPerson.setPhoneNumber(phoneNum);
				scanner.nextLine();
				System.out.println("New Email ID : ");
				email = scanner.nextLine();
				thatPerson.setEmail(email);
			}
		}
	}
	
	public void deletePersonDetails() {
		Scanner scanner = new Scanner(System.in);
		String FirstName;
		String LastName;
		
		System.out.println("Enter name of a person to DELETE contact details");
		System.out.println("First Name : ");
		FirstName = scanner.nextLine();
		System.out.println("Last Name : ");
		LastName = scanner.nextLine();
		
		for(Person thatPerson : personList) {
			if(FirstName.equalsIgnoreCase(thatPerson.getFirstName()) && LastName.equalsIgnoreCase(thatPerson.getLastName())) {
				personList.remove(thatPerson);
			}
		}
	}
	
}
