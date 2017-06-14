package main;


public class ContactApp {

	public static void main(String[] args) {
		String option;
		do{
			String[] dataContacts = FileHelper.readFile("contacts.txt");
			if(dataContacts==null){			
				dataContacts = new String[0];		
			}
			ListPerson contacts = new ListPerson(dataContacts);
			UserInterface.printMenu();
			option = UserInterface.scanOption();
			
			switch(option){
			case "add":
				contacts.add(UserInterface.scanContacts());
				break;
			case "remove":
				//contacts.remove(contacts.findByName(UserInterface.nameStringScan()));
				break;
			case "sort":
				UserInterface.printList(contacts.sort());
				break;
			case "name":
				UserInterface.printList(contacts.findByName(UserInterface.nameStringScan()));
				break;
			case "mail":
				UserInterface.printList(contacts.findByEmail(UserInterface.mailStringScan()));
				break;
			case "set":
				//Person[] contactFind = contacts.findByName(UserInterface.nameStringScan()); 
				//Person setContact = UserInterface.scanContacts();
				//contacts.set(setContact, contacts.indexOf(contactFind[0]));
				break;
			case "list":
				UserInterface.printList(contacts.list());
				break;
			case "exit":
				System.out.println("Bye");
				break;
			default:
				System.out.println("Incorrect Option");
				break;
			}
			
		}while(!(option.equals("exit")));
	
	}

}
