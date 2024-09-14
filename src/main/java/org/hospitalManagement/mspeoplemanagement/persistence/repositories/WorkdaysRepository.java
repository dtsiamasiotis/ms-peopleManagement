package org.hospitalManagement.mspeoplemanagement.persistence.repositories;

import org.hospitalManagement.mspeoplemanagement.persistence.model.WorkDay;
import org.springframework.data.repository.ListCrudRepository;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;

public interface WorkdaysRepository extends ListCrudRepository<WorkDay, Long> {
    List<WorkDay> findAllByPersonnelIdAndStartTimeBefore(Long personnelId, ZonedDateTime tstamp);
    List<WorkDay> findAllByPersonnelIdAndStartTimeAfterAndStartTimeBefore(Long personnelId, ZonedDateTime after, ZonedDateTime before);
}
