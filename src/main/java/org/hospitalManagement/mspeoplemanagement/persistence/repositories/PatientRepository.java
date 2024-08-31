package org.hospitalManagement.mspeoplemanagement.persistence.repositories;

import org.hospitalManagement.mspeoplemanagement.persistence.model.Patient;
import org.springframework.data.repository.ListCrudRepository;

public interface PatientRepository extends ListCrudRepository<Patient, Long> {
}
