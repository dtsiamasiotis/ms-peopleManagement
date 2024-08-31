package org.hospitalManagement.mspeoplemanagement.services;

import org.hospitalManagement.mspeoplemanagement.persistence.model.Patient;
import org.hospitalManagement.mspeoplemanagement.persistence.model.Personnel;
import org.hospitalManagement.mspeoplemanagement.persistence.repositories.PersonnelRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonnelManagementService {
    private PersonnelRepository personnelRepository;

    public PersonnelManagementService (PersonnelRepository personnelRepository) {
        this.personnelRepository = personnelRepository;
    }

    public List<Personnel> getListOfPersonnel() {
        return personnelRepository.findAll();
    }

    public void createPersonnel(Personnel personnel) {
        personnelRepository.save(personnel);
    }

    public Personnel getPersonnelById(Long id) {
        Optional<Personnel> personnel = personnelRepository.findById(id);
        if(!personnel.isEmpty())
            return personnel.get();
        else
            return null;
    }

    public void calculateMonthlyCompensation() {

    }
}
