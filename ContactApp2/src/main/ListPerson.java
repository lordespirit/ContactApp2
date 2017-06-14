package main;

import java.util.Arrays;

public class ListPerson {
	
	/*
	 * Métodos a introducir
	 * -add
	 * -remove
	 * -set (edit)
	 * -find by name
	 * -find by email
	 * -sort
	 * -indexOf
	 */
		
		private Person[] contacts;

		
		public ListPerson(String[] strContacts){
			iniContact(strContacts); 
		}
		
		private void iniContact(String[] strContacts) {
			contacts = new Person[strContacts.length]; 
			  
			  for(int i=0; i<strContacts.length; i++){
				  String contactFileFormat = strContacts [i]; 
				  Person contact = new Person(contactFileFormat);
			      //add(contact); 
				  contacts[i] = contact;  
			  }
		}


		/**
		 * Retorna el numero de personas que contiene
		 * @return
		 */
		public int size() {
			return contacts.length;
		}

		/**
		 * Obtiene la persona que tiene el index i 
		 * @param i
		 * @return
		 */
		public Person get(int i) {
			return contacts[i];
		}
		
		/** Sobreescribe una persona de la lista en la posición dada en la variable 'index' 
		 * @param person
		 * @param index
		 */
		public void set(Person person, int index){
			if(index<0||index>contacts.length){
				throw new RuntimeException("Indice mal situado [OUT OF RANGE]");
			}else{
				contacts[index]=person;
				UserInterface.write(contacts);
			}
		}
		

		/**
		 * Retorna el index del objeto person 
		 * @param person
		 * @return
		 */
		public int indexOf(Person person){
			int index = -1; 
			for(int i=0; i<contacts.length; i++){
				if(contacts[i].equals(person)){
					index = i;
					 break; 
				}
			}	
			return index; 
		}

		/**
		 * Adiciona una persona al alrreglo interno de personas. 
		 * Se adiciona en la ultima posicion
		 * @param contact
		 */
		public void add(Person contact) {			
			boolean exists = false;
			String name = contact.getName();
			String surname = contact.getSurname();
			for(int i=0;i<contacts.length;i++){
				if((contacts[i].getName().equals(name))&&(contacts[i].getSurname().equals(surname))){
					exists = true;
				}
			}
			if(!exists){
				Person[] copyContacts = new Person[contacts.length+1];
				for(int i=0;i<contacts.length;i++){
					copyContacts[i]=contacts[i];
				}
				copyContacts[contacts.length]=contact;		
				contacts = copyContacts;	
				UserInterface.write(contacts);
			}else{
				throw new RuntimeException("El usuario con ese nombre y apellido ya existe");
			}
		}
		
		/**
		 * Elimina una persona del la lista
		 * @param person
		 */
		public void remove(Person person) {
			int index = indexOf(person);
			remove(index);
		}	
		
		public void remove(int index){
			if(index<0||index>contacts.length){
				return;
			}else{
				Person[] copyContacts = new Person[contacts.length-1];
				int j=0;
				for(int i=0;i<contacts.length;i++){
					if(i!=index){
						copyContacts[j++]=contacts[i];
					}
				}
				contacts = copyContacts;
			}
		}
		
		
		/**
		 * Retorna todas las personas que coontengan strString en su campo name
		 * @return
		 */
		public Person[] findByName(String strName){
			Person finder[];
			int control=0;
			for(int i=0;i<contacts.length;i++){
				if(contacts[i].getName().contains(strName)){
					control++;
				}
			}
			finder = new Person[control];
			control=0;
			for(int i=0;i<contacts.length;i++){
				if(contacts[i].getName().contains(strName)){
					finder[control++]=contacts[i];
				}
			}
			return finder;	
		}

		/**
		 * Borra usuario pasando un nombre y apellido
		 * Busca entonces el índice si existe.
		 */
		public void EraseByFullName(String strName, String strSurname){
			int control = -1;
			for(int i=0;i<contacts.length;i++){
				if((contacts[i].getName().equals(strName))&&(contacts[i].getSurname().equals(strSurname))){
					control = i;
				}
			}
			if(control>=0){
				Person copyContacts[] = new Person[contacts.length-1];
				int j=0;
				for(int i=0;i<contacts.length;i++){
					if(i!=control){
						copyContacts[j++]=contacts[i];
					}
				}
				contacts = copyContacts;
				UserInterface.write(contacts);
				
			}else{
				throw new RuntimeException("Usuario no existe");
			}
			
		}
		/**
		 * Retorna todas las personas que contengan strMail en su campo email
		 * @return
		 */
		public Person[] findByEmail(String strMail){
			Person array[] = new Person[contacts.length];  
			int counter = 0;
			
			for(Person person: contacts){
				if(person.getMail().contains(strMail))
					array[counter++]=person; 
			}
			
			Person personsWidthEmail[] = new Person[counter];  
			for(int i=0,k=0; i<contacts.length; i++){
				if(contacts[i].getMail().contains(strMail))
					personsWidthEmail[k++]=contacts[i];
			}
			
		 return personsWidthEmail;
		}
		
		/**
		 * Retorna una copia de la lista ordenada alfabeticamente
		 * @return
		 */
		public Person[] sort(){
			
			String sortNames[] = new String[contacts.length];
			Person sortContacts[] = new Person[contacts.length];
			
			for(int i=0;i<contacts.length;i++){
				sortNames[i] = contacts[i].getFullName();
			}
			Arrays.sort(sortNames);
			int control=0;
			for(int i=0;i<sortNames.length;i++){
				for(int j=0;j<contacts.length;j++){
					if(sortNames[i].equals(contacts[j].getFullName())){
						sortContacts[control++]=contacts[j];
					}
				}
			}
			
			return sortContacts;
		}
		
		public Person[] list(){
			Person copyContacts[] = new Person[contacts.length];
			for(int i=0;i<contacts.length;i++){
				copyContacts[i]=contacts[i];
			}
			return copyContacts;
		}

		
		@Deprecated
		public int indexOf(String name, String surname) {
			int index = -1;
			for(int i=0;i<contacts.length;i++){
				if((contacts[i].getName().equals(name))&&(contacts[i].getSurname().equals(surname))){
					index = i;
				}
			}
			if(index>=0){
				return index;
			}else{
				throw new RuntimeException("Usuario no existe");
			}
		}
}
