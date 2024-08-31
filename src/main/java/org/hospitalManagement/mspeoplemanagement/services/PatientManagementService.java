package org.hospitalManagement.mspeoplemanagement.services;

import org.hospitalManagement.mspeoplemanagement.persistence.model.Patient;
import org.hospitalManagement.mspeoplemanagement.persistence.repositories.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientManagementService {

    private PatientRepository patientRepository;

    public PatientManagementService (PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public List<Patient> getListOfPatients() {
        return patientRepository.findAll();
    }

    public void createPatient(Patient patient) {
        patientRepository.save(patient);
    }

    public Patient getPatientById(Long id) {
        Optional<Patient> patient = patientRepository.findById(id);
        if(!patient.isEmpty())
            return patient.get();
        else
            return null;
    }
}
