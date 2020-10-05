package AddressBookMain;

import java.util.*;

public class AddressBookMain extends AddressBook{
	
	public static void main(String[] args) {
		
		System.out.println("WELCOME TO ADDRESS BOOK");
		
		Scanner scanner = new Scanner(System.in);
		HashMap<String, AddressBook> addressBookMap = new HashMap<>();
		do {
			System.out.println("1. Add new address book"+"\n2. Perform action on existing address book");
			int option = scanner.nextInt();
			scanner.nextLine();
			
			switch(option) {
				case 1:
					System.out.println("Enter city name : ");
					String addressBookName = scanner.nextLine();
					AddressBook NewAddressBook = new AddressBook(addressBookName);
					addressBookMap.put(addressBookName, NewAddressBook);
					NewAddressBook.addPersonDetails();
					break;
					
				case 2:
					System.out.println("Enter city name : ");
					addressBookName = scanner.nextLine();
					System.out.println("1. Add details\n2. Edit details\n3. Delete details\n4. Display all contacts");
					int choice = scanner.nextInt();
					scanner.nextLine();
					
					switch(choice) {
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
						addressBookMap.get(addressBookName).displayAllContacts();
						break;
					default:
						System.out.println("Select correct choice");
						break;
					}
					break;
				default:
					System.out.println("Select correct option");
					break;
			}
			System.out.println("Enter 'y' if you want to PERFORM NEW ACTION \nEnter any other key to EXIT");
			
		}while(scanner.nextLine().equalsIgnoreCase("y"));
	}
}
