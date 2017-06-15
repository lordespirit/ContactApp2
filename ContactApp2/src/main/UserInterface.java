package main;

import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

import utils.Input;
import utils.Utils;

public class UserInterface {

	public static Person scanContacts(){
		String name,surname,phone,mail,address;
		do{
			System.out.print("|AÑADIR NUEVO CONTACTO|\nIntroduce nombre del contacto : ");
			name = Input.scannLine();
			System.out.print("Introduce apellido del contacto : ");
			surname = Input.scannLine();
			do{
				System.out.print("Introduce teléfono del contacto : ");
				phone = Input.scannLine();
				if(!phoneValidator(phone)){
					System.out.println("Formato teléfono incorrecto\n"
							+ "Formato : únicamente números - Mínimo 9 cifras - Máximo 13");
				}else{
					phone = phoneFormat(phone);
				}
			}while(!phoneValidator(phone));
			do{
				System.out.print("Introduce correo electrónico del contacto : ");
				mail = Input.scannLine();
				if(!mailValidator(mail)){
					System.out.println("El correo no está en formato correcto...");
				}
			}while(!mailValidator(mail));
			System.out.print("Introduce dirección del contacto : ");
			address = Input.scannLine();
			if((name.equals("")||surname.equals("")||phone.equals("")|| mail.equals("")||address.equals(""))){
				System.out.println("ERROR No has rellenado todos los datos!");
				try {
					TimeUnit.SECONDS.sleep(4);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}while(name.equals("")||surname.equals("")||phone.equals("")|| mail.equals("")||address.equals(""));
		Person newContact = new Person(name+" "+surname+";"+phone+";"+mail+";"+address);
		return newContact;
	}
	
	public static Person scanNewContacts(Person defaultPerson){
		
		System.out.println("|NUEVA INFO DEL CONTACTO|\nLo que se deje en blanco se dejará el dato antiguo\nIntroduce nuevo nombre si se desea : ");
		
		System.out.println("Introduce nuevo nombre si se desea : ");
		String name = Input.scannLine();
		if(name.equals(""))
			name = defaultPerson.getName();
		
		System.out.print("Introduce nuevo apellido si se desea : ");
		String surname = Input.scannLine();
		if(surname.equals(""))
			surname = defaultPerson.getSurname();
		
		String phone;
		do{
			System.out.print("Introduce nuevo teléfono si se desea : ");
			phone = Input.scannLine();
			if(phone.equals(""))
				phone = defaultPerson.getPhone();
			if(!phoneValidator(phone))
				System.out.println("ERROR! Formato teléfono incorrecto\n Formato : únicamente números - Mínimo 9 cifras - Máximo 13");
		}while(!phoneValidator(phone));
		
		String mail;
		do{
			System.out.print("Introduce nuevo correo electrónico si se desea : ");
			mail = Input.scannLine();
			if(mail.equals(""))
				mail = defaultPerson.getMail();
			if(!mailValidator(mail))
				System.out.println("ERROR! Formato de correo electrónico incorrecto");
		}while(!mailValidator(mail));
		
		System.out.print("Introduce nuevo dirección de residencia si se desea : ");
		String address = Input.scannLine();
		if(address.equals(""))
			address = defaultPerson.getAddress();

		return new Person(name+" "+surname+";"+phone+";"+mail+";"+address);
		
	}

	public static String[] scanCompleteName(){
		System.out.print("Introduce nombre de contacto : ");
		String name = Input.scannLine();
		System.out.print("Introduce apellido de contacto : ");
		String surname = Input.scannLine();
		String fullname[] = {name,surname};
		return fullname;
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

	public static void remove(String strName, String strSurname, ListPerson contacts) {
		contacts.EraseByFullName(strName, strSurname);
	}

	public static String nameStringScan() {
		String name;
		do{
		System.out.print("Introduce nombre de contacto : ");
		name = Input.scannLine();
			if(name.equals("")){
				System.out.println("Error, introduce un nombre");
			}
		}while(name.equals(""));
		return name;
	}

	public static String surnameStringScan() {
		String surname;
		do{
		System.out.print("Introduce apellido de contacto : ");
		surname = Input.scannLine();
			if(surname.equals("")){
				System.out.println("Error, introduce un apellido");
			}
		}while(surname.equals(""));
		return surname;
	}
	
	private static boolean mailValidator(String mail){
		String pattern = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
		if(mail.matches(pattern)){
			return true;
		}else{
			return false;
		}
	}
	
	private static boolean phoneValidator(String phone) {
		String pattern = "^[0-9]{9,13}$";
				if(phone.matches(pattern)){
					return true;
				}else{
					return false;
				}
	}
	
	private static String phoneFormat(String phone) {
		final Pattern REGEX_PATTERN = 
				Pattern.compile("^(0034|\\+34)?(\\d\\d\\d)-? ?(\\d\\d)-? ?(\\d)-? ?(\\d)-? ?(\\d\\d)$", Pattern.MULTILINE);
		        return REGEX_PATTERN.matcher(phone).replaceAll("+34 $2 $3$4 $5$6");
	}

	public static int scanIndexToEdit() {
		System.out.print("Introduce el índice del contacto que desea editar : ");
		int index = Input.scannInt();
		return index-1;
	}

	public static void selectRemoveMethod(ListPerson contacts) {
		System.out.println("Deseas eliminar contacto por índice o por nombre y apellido");
		String option;
		do{
		System.out.println("Indice = 'i' o 'I' || Nombre Completo - 'n' o 'N' ");
		option = Input.scannLine();
		if(option.equals("i")||option.equals("I")){
			UserInterface.printList(contacts.list());
			System.out.print("Elige el índice del usuario a borrar : ");
			int index = Input.scannInt();
			contacts.remove(index-1);
		}else if(option.equals("n")||option.equals("N")){
			String name = UserInterface.nameStringScan();
			String surname = UserInterface.surnameStringScan();
			remove(name, surname, contacts);
		}else{
			System.out.println("Opción incorrecta");
		}
		}while(!(option.equals("i")||option.equals("I")||option.equals("n")||option.equals("N")));
		
	}
	
}
