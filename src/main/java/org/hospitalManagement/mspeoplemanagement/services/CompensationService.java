package org.hospitalManagement.mspeoplemanagement.services;

import lombok.RequiredArgsConstructor;
import org.hospitalManagement.mspeoplemanagement.persistence.model.MonthlyCompensation;
import org.hospitalManagement.mspeoplemanagement.persistence.model.Personnel;
import org.hospitalManagement.mspeoplemanagement.persistence.model.WorkDay;
import org.hospitalManagement.mspeoplemanagement.persistence.repositories.MonthlyCompensationRepository;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.ZonedDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CompensationService {

    private final WorkdaysManagementService workdaysManagementService;
    private final PersonnelManagementService personnelManagementService;
    private final MonthlyCompensationRepository monthlyCompensationRepository;

    public void calculateMonthlyCompensation() {
        List<Personnel> personnelList = personnelManagementService.getListOfPersonnel();
        ZonedDateTime now = ZonedDateTime.now();
        ZonedDateTime startDate = now.minusMonths(1).withDayOfMonth(1).withHour(0).withMinute(0).withSecond(0);
        ZonedDateTime endDate = now.withDayOfMonth(1).withHour(0).withMinute(0).withSecond(0);
        for (Personnel personnel : personnelList) {
            List<WorkDay> workDays = workdaysManagementService.getWorkDaysByPersonnelIdAndBetween(personnel.getId(), startDate, endDate);
            long overtime = 0;
            for (WorkDay workDay : workDays) {
                Duration duration = Duration.between(workDay.getStartTime(), workDay.getEndTime());
                if (duration.toHours() > 8) {
                    overtime += (duration.toHours() - 8);
                }
            }

            long totalAmount = personnel.getBaseSalary() + overtime * 25;
            MonthlyCompensation monthlyCompensation = new MonthlyCompensation();
            monthlyCompensation.setPersonnelId(personnel.getId());
            monthlyCompensation.setTotalAmount(totalAmount);
            monthlyCompensationRepository.save(monthlyCompensation);
        }

    }
}
