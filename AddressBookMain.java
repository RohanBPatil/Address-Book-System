package AddressBookMain;

import java.util.*;
import java.util.stream.Collectors;

public class AddressBookMain extends AddressBook {
		
	public static HashMap<String, AddressBook> addressBookMap = new HashMap<>();
	
	public void addPersonDetails() {
		Scanner scanner = new Scanner(System.in);
		
		String checkToAdd = "y";
		
		while(checkToAdd.equalsIgnoreCase("y")) {
			//variables
			String firstName;
			String lastName;
			String address;
			String city;
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
			System.out.println("City : ");
			city = scanner.nextLine();
			System.out.println("State : ");
			state = scanner.nextLine();
			System.out.println("ZIP : ");
			zip = scanner.nextInt();
			System.out.println("Phone number : ");
			phoneNum = scanner.nextLong();
			scanner.nextLine();
			System.out.println("Email ID : ");
			email = scanner.nextLine();
			
			Person new_person = new Person(firstName, lastName, address, city, state, zip, phoneNum, email);
					
			boolean duplicate = addressBookMap.get(state).personList.stream().anyMatch(n -> n.equals(new_person));
			if(!duplicate) {
				addressBookMap.get(state).personList.add(new_person);
			}
			else {
				System.out.println("Same contact is already present Hence WILL NOT BE ADDED to address book");
			}
			
			System.out.println("Enter 'y' to ADD NEW PERSON'S DETAILS.\nEnter any other key to STOP ADDING.");
			checkToAdd = scanner.nextLine();
		}
		
	}
	
	public void searchPersonByCity(String name, String city) {
		List<Person> list = new ArrayList<Person>();
		for(Map.Entry<String, AddressBook> entry : addressBookMap.entrySet()) {
			list = entry.getValue().getPersonList().stream()
					.filter(c -> c.getCity().equals(city))
					.filter(c -> (c.getFirstName() + " " + c.getLastName())
					.equals(name)).collect(Collectors.toList());
		}
		for(Person c : list) {
			System.out.println(c);
		}
	}	
	
	public void searchPersonByState(String name, String state) {
		List<Person> list = new ArrayList<Person>();
		for(Map.Entry<String, AddressBook> entry : addressBookMap.entrySet()) {
			list = entry.getValue().getPersonList().stream()
					.filter(c -> c.getState().equals(state))
					.filter(c -> (c.getFirstName() + " " + c.getLastName())
					.equals(name)).collect(Collectors.toList());
		}
		for(Person c : list) {
			System.out.println(c);
		}
	}
	
	
	public static void main(String[] args) {
		
		System.out.println("WELCOME TO ADDRESS BOOK");
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter first Address Book name : ");
		String addressBookName = scanner.nextLine();
		AddressBookMain addressBookMain = new AddressBookMain();
		AddressBook NewAddressBook = new AddressBook(addressBookName);
		addressBookMap.put(addressBookName, NewAddressBook);
		addressBookMain.addPersonDetails();
		
		String yes = "y";
		
		do {
			System.out.println("1. Add contact\n2. Edit contact\n3. Delete contact\n4. Add new Address Book\n5. Search person by city\n6. Search person by state");
			int option = scanner.nextInt();
			switch(option) {
			case 1:
				addressBookMain.addPersonDetails();
				break;
			case 2:
				System.out.println("Enter name of address book");
				String name = scanner.nextLine();
				addressBookMap.get(name).editPersonDetails();
				break;
			case 3:
				System.out.println("Enter name of address book");
				name = scanner.nextLine();
				addressBookMap.get(name).deletePersonDetails();
				break;
			case 4:
				System.out.println("Enter Address Book name : ");
				name = scanner.nextLine();
				NewAddressBook = new AddressBook(name);
				addressBookMap.put(name, NewAddressBook);
				break;
			case 5:
				System.out.println("Enter the name to search : ");
				String person = scanner.nextLine();
				System.out.println("Enter the city : ");
				String city = scanner.nextLine();
				addressBookMain.searchPersonByCity(person,city);
				break;
			case 6:
				System.out.println("Enter the name to search : ");
				person = scanner.nextLine();
				System.out.println("Enter the state : ");
				String state = scanner.nextLine();
				addressBookMain.searchPersonByCity(person,state);
				break;
			default:
				System.out.println("Select correct choice");
				break;
			}
			System.out.println("Enter 'y' if you want to PERFORM NEW ACTION \nEnter any other key to EXIT");
			yes = scanner.nextLine();
		}while(yes.equalsIgnoreCase("y"));
		
	}
	
}
