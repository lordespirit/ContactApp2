package test;

import org.junit.Assert;
import org.junit.Test;

import main.Person;

public class TestPerson {

	
	@Test	
	public void testContructorPerson(){
		
		String strContact0= "Pedro Picapiedra;003412415789;pedro@pica.com;Marmol 45"; 
		 Person person = new Person(strContact0); 
		 Assert.assertEquals("Pedro", person.getName()); 
		 Assert.assertEquals("Picapiedra", person.getSurname());
		 Assert.assertEquals("003412415789", person.getPhone()); 
		 Assert.assertEquals("pedro@pica.com", person.getMail()); 
		 Assert.assertEquals("Marmol 45", person.getAddress());
	}
	
	
}
