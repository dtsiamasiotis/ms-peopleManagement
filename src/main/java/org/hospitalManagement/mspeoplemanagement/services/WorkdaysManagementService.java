package org.hospitalManagement.mspeoplemanagement.services;

import org.hospitalManagement.mspeoplemanagement.persistence.model.WorkDay;
import org.hospitalManagement.mspeoplemanagement.persistence.repositories.WorkdaysRepository;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import static java.time.ZonedDateTime.now;

@Service
public class WorkdaysManagementService {
    private WorkdaysRepository workdaysRepository;

    public WorkdaysManagementService(WorkdaysRepository workdaysRepository) {
        this.workdaysRepository = workdaysRepository;
    }

    public void startWorkDay(Long personnelId) {
        WorkDay workDay = new WorkDay();
        workDay.setPersonnelId(personnelId);
        workDay.setStartTime(now());
        workdaysRepository.save(workDay);
    }

    public void endWorkDay(Long personnelId) {
        WorkDay mostRecentWorkday = null;
        List<WorkDay> workDays = workdaysRepository.findAllByPersonnelIdAndStartTimeBefore(personnelId,now());
        if(!workDays.isEmpty()){
            mostRecentWorkday = workDays.stream().sorted(Comparator.comparing(WorkDay::getStartTime).reversed()).toList().get(0);
            mostRecentWorkday.setEndTime(now());
        }
        else {
            mostRecentWorkday = new WorkDay();
            mostRecentWorkday.setPersonnelId(personnelId);
            mostRecentWorkday.setEndTime(now());
        }

        workdaysRepository.save(mostRecentWorkday);
    }
}
