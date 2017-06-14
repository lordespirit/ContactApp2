package main;

public class Person {

	private String name;
	private String surname;
	private String phone;
	private String mail;
	private String address;
	
	public Person(String contactStr){
		String[] values = contactStr.split(";");
		if(values.length<4)
			throw new RuntimeException("Formato incorrecto en contactStr");
		
		String fullName[] = values[0].split(" ");
		String nombre = fullName.length==2?fullName[0]:values[0];
		String apellido = fullName.length==2?fullName[1]:"";
		String phone = values[1];
		String mail = values[2];
		String address = values[3];
		
		setName(nombre);
		setSurname(apellido);
		setMail(mail);
		setPhone(phone);
		setAddress(address);
		
		/*
		 * TAMBIÉN SE PODRÍA HACER COMO THIS.VARIABLE
		 * this.name = fullName.length==2?fullName[0]:values[0];
		 * this.surname = = fullName.length==2?fullName[1]:"";
		 * this.phone = values[1];
		 * this.mail = values[2];
		 * this.address = values[3];
		 */
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	@Override
	public String toString(){
		return name + " " + surname + "\t;\t" + phone + "\t;\t" + mail + "\t;\t" + address;
	}

	@Override
	public boolean equals(Object obj) {
		Person person = (Person) obj;
		
		if(this.name.equals(person.getName())&&
				this.surname.equals(person.getSurname())&&
					this.phone.equals(person.getPhone())&&
						this.mail.equals(person.getMail())&&
							this.address.equals(person.getAddress())
								){
		return true;
		}else{
		
		return false;
		}
	}

	
	public String getFullName(){
		return getName() + " " + getSurname();
	}

	
	
}
