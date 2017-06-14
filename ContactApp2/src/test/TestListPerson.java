package test;

import org.junit.Assert;
import org.junit.Test;

import main.ListPerson;
import main.Person;

public class TestListPerson {

	@Test
	public void listPersonConstructor(){
		String strContacts[] = new String[2];
		strContacts[0]= "Edu Valles;212451541;edu@edu.com;Av. Madrid 40";
		strContacts[1]= "Jose Miguel;123456;jose@miguel.com;Calle Marina 5";
		ListPerson ejemplo = new ListPerson(strContacts);
		Person person = ejemplo.get(0);
		
		Assert.assertEquals(2,strContacts.length);
		Assert.assertEquals("Edu", person.getName());
		Assert.assertEquals("Valles", person.getSurname());
		Assert.assertEquals("212451541", person.getPhone());
		Assert.assertEquals("edu@edu.com", person.getMail());
		Assert.assertEquals("Av. Madrid 40", person.getAddress());
		
	}
	
	@Test
	public void testAddList(){
		String strContactAdd = "Pablo Marmol;0034123456789;pablo@marmol.com;Marmol 47";
		String[] strNewList = new String[] {"Pedro Picapiedra;0034987654323;pedro@piedra.com;Marmol 45"};
		ListPerson list = new ListPerson(strNewList);
		Person newPerson = new Person(strContactAdd);
		list.add(newPerson);
		
		Assert.assertEquals(2,list.size());
		Assert.assertEquals("Pablo", list.get(1).getName());
	}
	
	@Test	
	public void testRemoveList(){
		

		String strContact0= "Pedro Picapiedra;003412415789;pedro@pica.com;Marmol 45"; 
		String strContact1= "Pablo Marmol; 003412415700; pablo@pica.com;Marmol 46"; 
		String[] strContacts= 
				new String[]{strContact0,strContact1}; 
		
		ListPerson list = new ListPerson(strContacts);
		
		list.remove(list.get(0));
		
		Assert.assertEquals(1, list.size());
		//Assert.assertEquals("Pedro", list.get(0).getName());
		//Assert.assertEquals("Picapiedra", list.get(0).getSurname());
		Assert.assertEquals("Pablo", list.get(0).getName());
		Assert.assertEquals("Marmol", list.get(0).getSurname());
		
	}
	
	@Test
	public void testSet(){
		
		String strContact0= "Pedro Picapiedra;003412415789;pedro@pica.com;Marmol 45"; 
		String strContact1= "Pablo Marmol; 003412415700; pablo@pica.com;Marmol 46"; 
		String strContact2= "Alicia Colins; 003478522541; alicia@colins.com;Poland 78"; 
		String[] strContacts= 
				new String[]{strContact0,strContact1,strContact2}; 
		
		ListPerson list = new ListPerson(strContacts);
		String strContact3 = "Pablito Marmolado; 003412415700; pablo@pica.com;Marmol 46";
		Person person = new Person(strContact3);
			
		list.set(person, 1);
		
		Assert.assertEquals(3, list.size());
		//Assert.assertEquals("Pedro", list.get(0).getName());
		//Assert.assertEquals("Picapiedra", list.get(0).getSurname());
		Assert.assertEquals("Pablito", list.get(1).getName());
		Assert.assertEquals("Marmolado", list.get(1).getSurname());
	}
	
	@Test
	public void testSort(){
		String strContact0= "Soraya García;003412415789;soraya@garcia.com;Calle Ferrer 45"; 
		String strContact1= "Lorena Porter;003412415700;Lorena@porter.com;Avenida Lopera 19"; 
		String strContact2= "Anna Gaston;003478522541;Anna@gaston.com;Riera Alta 77"; 
		String[] strContacts= 
				new String[]{strContact0,strContact1,strContact2}; 
		ListPerson list = new ListPerson(strContacts);
		Person person[] = list.sort();
		
		Assert.assertEquals("Anna",person[0].getName());
		Assert.assertEquals("Gaston",person[0].getSurname());
		Assert.assertEquals("003478522541",person[0].getPhone());
		Assert.assertEquals("Anna@gaston.com",person[0].getMail());
		Assert.assertEquals("Riera Alta 77",person[0].getAddress());
		Assert.assertEquals("Lorena",person[1].getName());
		Assert.assertEquals("Porter",person[1].getSurname());
		Assert.assertEquals("Soraya",person[2].getName());
		Assert.assertEquals("García",person[2].getSurname());
	}
	
	@Test
	public void testSearchByName(){
		String strContact0= "Soraya García;003412415789;soraya@garcia.com;Calle Ferrer 45"; 
		String strContact1= "Lorena Porter;003412415700;Lorena@porter.com;Avenida Lopera 19"; 
		String strContact2= "Anna Gaston;003478522541;Anna@gaston.com;Riera Alta 77"; 
		String strContact3= "Ana Raventós;003423232323;Ana@rav.es;Calle Baja 199";
		String[] strContacts= 
				new String[]{strContact0,strContact1,strContact2,strContact3}; 
		ListPerson list = new ListPerson(strContacts);
		
		Person person[] = list.findByName("An");
		
		Assert.assertEquals(2, person.length);
		Assert.assertEquals("Anna", person[0].getName());
		Assert.assertEquals("Ana", person[1].getName());
		
	}
}
