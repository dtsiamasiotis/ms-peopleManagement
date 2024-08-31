package org.hospitalManagement.mspeoplemanagement;

import org.hospitalManagement.mspeoplemanagement.persistence.model.Occupation;
import org.hospitalManagement.mspeoplemanagement.persistence.model.Personnel;
import org.hospitalManagement.mspeoplemanagement.persistence.repositories.PersonnelRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class RepositoriesTest implements CommandLineRunner {

    private PersonnelRepository personnelRepository;

    public RepositoriesTest (PersonnelRepository personnelRepository) {
        this.personnelRepository = personnelRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Personnel doctor = new Personnel();
        doctor.setOccupation(Occupation.Doctor);
        //personnelRepository.save(doctor);
    }
}
