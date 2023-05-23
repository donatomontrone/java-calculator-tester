package org.java.businessTest;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assumptions.*;
import java.time.LocalDate;
import java.util.Random;

import org.java.business.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

public class EmployeeTest {
		Employee e = new Employee();
		final  String[] names = {"Alice", " Bob ", "", "Charlie", " David ", "Eve", "", "Frank", " Grace ", "Henry"," "};
		final  String[] lastnames = {"Rossi", " Bianchi ", "", "Verdi","" , " Gialli ", "Neri", "", "Bianchini", " Grigi ", "Marroni", " "};

		final  LocalDate[] births = {LocalDate.of(2000, 12, 06), LocalDate.of(1990, 03, 28), LocalDate.of(2023, 8, 17), LocalDate.of(1976, 11, 02), LocalDate.of(1996, 07, 10), LocalDate.of(2033, 02, 14), LocalDate.of(1967, 9, 21), LocalDate.of(2029, 05, 05), LocalDate.of(1994, 10, 30), LocalDate.of(2025, 04, 18)};

		final  String[] roles = {"employee", "boss", "manager", "designer"};
		final static LocalDate TODAY = LocalDate.now();
		 Random rnd = new Random();
		 String name;
		 String lastname;
		 LocalDate date;
		 String role;

		@BeforeEach
		public void randomize() {
			name = names[rnd.nextInt(names.length)];
			lastname = lastnames[rnd.nextInt(lastnames.length)];
			date = births[rnd.nextInt(births.length)];
			role = roles[rnd.nextInt(roles.length)];
		}	
		
	@RepeatedTest(10)
		public void setEmptyNameTest() throws Exception {
			assumeTrue(name.trim().isEmpty());
			assertThrows(Exception.class, () -> e.setName(name));
		}
	@RepeatedTest(10)
	public void setNameTest() throws Exception {
		assumeTrue(!name.trim().isEmpty());
		e.setName(name);
	}
	@RepeatedTest(10)
	public void setEmptyLastnameTest() throws Exception {
		assumeTrue(lastname.trim().isEmpty());
		assertThrows(Exception.class, () -> e.setLastname(lastname));
	}
	
	public void setLastnameTest() throws Exception {
		assumeTrue(!lastname.trim().isEmpty());
		e.setLastname(lastname);
	}
	
	@RepeatedTest(10)
	public void setFutureDateOfBirthTest() throws Exception {
		assumeTrue(TODAY.isBefore(date));
		
		assertThrows(Exception.class, () -> e.setDateOfBirth(date));
	}
	@RepeatedTest(10)
	public void setDateOfBirthTest() throws Exception {
		assumeTrue(TODAY.isAfter(date));
		e.setDateOfBirth(date);
	}
	
	@RepeatedTest(10)
	public void setWrongRoleTest() throws Exception {
		System.err.println(role);
		assumeTrue(!(role.equals("boss")) && !(role.equals("employee")));
		assertThrows(Exception.class, () -> e.setRole(role));
	}
	
	@RepeatedTest(10)
	public void setRoleTest() throws Exception {
		System.out.println(role);
		assumeTrue((role.equals("boss")) || (role.equals("employee")));
		e.setRole(role);
	}
	
}
