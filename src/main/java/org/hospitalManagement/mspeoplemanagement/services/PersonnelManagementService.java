package org.hospitalManagement.mspeoplemanagement.services;

import org.hospitalManagement.mspeoplemanagement.persistence.model.MonthlyCompensation;
import org.hospitalManagement.mspeoplemanagement.persistence.model.Patient;
import org.hospitalManagement.mspeoplemanagement.persistence.model.Personnel;
import org.hospitalManagement.mspeoplemanagement.persistence.model.WorkDay;
import org.hospitalManagement.mspeoplemanagement.persistence.repositories.MonthlyCompensationRepository;
import org.hospitalManagement.mspeoplemanagement.persistence.repositories.PersonnelRepository;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.List;
import java.util.Optional;

@Service
public class PersonnelManagementService {
    private PersonnelRepository personnelRepository;
    private WorkdaysManagementService workdaysManagementService;
    private MonthlyCompensationRepository monthlyCompensationRepository;

    public PersonnelManagementService (PersonnelRepository personnelRepository, WorkdaysManagementService workdaysManagementService) {
        this.personnelRepository = personnelRepository;
        this.workdaysManagementService = workdaysManagementService;
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


}
