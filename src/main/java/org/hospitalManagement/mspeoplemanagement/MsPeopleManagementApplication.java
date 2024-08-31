package org.hospitalManagement.mspeoplemanagement;

import org.hospitalManagement.mspeoplemanagement.persistence.model.Occupation;
import org.hospitalManagement.mspeoplemanagement.persistence.model.Personnel;
import org.hospitalManagement.mspeoplemanagement.persistence.repositories.PersonnelRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Optional;

@SpringBootApplication
public class MsPeopleManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsPeopleManagementApplication.class, args);
	}

}
