package AddressBookMain;

import java.util.*;

public class AddressBookMain extends AddressBook{
	
	public static void main(String[] args) {
		
		System.out.println("WELCOME TO ADDRESS BOOK");
		
		Scanner scanner = new Scanner(System.in);
		HashMap<String, AddressBook> addressBookMap = new HashMap<>();
		
		System.out.println("Enter first Address Book name : ");
		String addressBookName = scanner.nextLine();
		AddressBook NewAddressBook = new AddressBook(addressBookName);
		addressBookMap.put(addressBookName, NewAddressBook);
		NewAddressBook.addPersonDetails();
		String yes = "y";
		do {
			System.out.println("1. Add contact\n2. Edit contact\n3. Delete contact\n4. Add new Address Book");
			int option = scanner.nextInt();
			switch(option) {
			case 1:
				addressBookMap.get(addressBookName).addPersonDetails();
				break;
			case 2:
				addressBookMap.get(addressBookName).editPersonDetails();
				break;
			case 3:
				addressBookMap.get(addressBookName).deletePersonDetails();
				break;
			case 4:
				System.out.println("Enter Address Book name : ");
				addressBookName = scanner.nextLine();
				NewAddressBook = new AddressBook(addressBookName);
				addressBookMap.put(addressBookName, NewAddressBook);
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
