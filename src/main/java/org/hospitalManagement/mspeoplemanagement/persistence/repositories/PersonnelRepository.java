package org.hospitalManagement.mspeoplemanagement.persistence.repositories;

import org.hospitalManagement.mspeoplemanagement.persistence.model.Personnel;
import org.springframework.data.repository.ListCrudRepository;

public interface PersonnelRepository extends ListCrudRepository<Personnel, Long> {
}
