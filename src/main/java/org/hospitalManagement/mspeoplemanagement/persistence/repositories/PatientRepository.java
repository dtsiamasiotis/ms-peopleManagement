package org.hospitalManagement.mspeoplemanagement.persistence.repositories;

import org.hospitalManagement.mspeoplemanagement.persistence.model.Patient;
import org.springframework.data.repository.ListCrudRepository;

import java.util.Optional;

public interface PatientRepository extends ListCrudRepository<Patient, Long> {
    Optional<Patient> findPatientByInsuranceNumber(Long insuranceNumber);
}
