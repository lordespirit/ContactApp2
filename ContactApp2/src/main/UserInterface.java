package main;

import utils.Input;

public class UserInterface {

	public static Person scanContacts(){
		System.out.print("|AÑADIR CONTACTO|\nIntroduce nombre del contacto : ");
		String name = Input.scannLine();
		System.out.print("Introduce apellido del contacto : ");
		String surname = Input.scannLine();
		System.out.print("Introduce teléfono del contacto : ");
		String phone = Input.scannLine();
		System.out.print("Introduce correo electrónico del contacto : ");
		String mail = Input.scannLine();
		System.out.print("Introduce dirección del contacto : ");
		String address = Input.scannLine();
		Person newContact = new Person(name+" "+surname+";"+phone+";"+mail+";"+address);
		return newContact;
	}
	
	public static String nameStringScan(){
		System.out.print("Introduce nombre de contacto : ");
		String name = Input.scannLine();
		return name;
	}
	
	public static String mailStringScan(){
		System.out.print("Introduce dirección de correo electrónico del contacto : ");
		String mail = Input.scannLine();
		return mail;
	}
	
	public static String scanOption(){
		System.out.print("< OPTION > : ");
		String option = Input.scannLine();
		return option;
	}
	
	public static void printMenu(){
		System.out.print("\n|MENU PRINCIPAL CONTACTOS|\nSelecciona una opción de la lista:\n"
				+ "add -\t Añadir contacto\n"
				+ "list -\t Listar todos los contactos\n"
				+ "sort -\t Listar contactos ordenados por nombre\n"
				+ "name -\t Buscar contacto por nombre\n"
				+ "mail -\t Buscar contacto por correo electrónico\n"
				+ "set -\t Editar datos de un contacto\n"
				+ "remove -\t Eliminar un contacto\n"
				+ "exit -\t Salir de programa\n");
	}
	
	public static void printList(Person[] array){
		for(int i=0;i<array.length;i++){
			System.out.println((i+1) + " - " + array[i]);
		}
	}
	
	public static void write(Person[] contacts){
		String[] strContacts = new String[contacts.length];
		for(int i=0;i<contacts.length;i++){
			strContacts[i]=(contacts[i].getName()+" "+contacts[i].getSurname()+";"+contacts[i].getPhone()+";"+contacts[i].getMail()+";"+contacts[i].getAddress());
		}
		FileHelper.writeFile(strContacts, "contacts.txt");
	}
	
}
