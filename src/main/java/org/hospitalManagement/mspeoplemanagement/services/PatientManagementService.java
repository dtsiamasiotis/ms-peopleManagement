package org.hospitalManagement.mspeoplemanagement.services;

import org.hospitalManagement.mspeoplemanagement.persistence.model.Patient;
import org.hospitalManagement.mspeoplemanagement.persistence.repositories.PatientRepository;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
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

    public Optional<Patient> getPatientById(Long id) {
        return patientRepository.findById(id);
    }

    public Optional<Patient> getPatientByInsuranceNumber(Long insuranceNumber) {
        return patientRepository.findPatientByInsuranceNumber(insuranceNumber);
    }

}
