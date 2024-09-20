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
            float salaryPerHour = (float)personnel.getBaseSalary() / (25 * 8);
            List<WorkDay> workDays = workdaysManagementService.getWorkDaysByPersonnelIdAndBetween(personnel.getId(), startDate, endDate);
            float overtime = 0;
            for (WorkDay workDay : workDays) {
                Duration duration = Duration.between(workDay.getStartTime(), workDay.getEndTime());
                float durationInHours = (float)duration.getSeconds() / 3600;

                if (durationInHours > 8) {
                    overtime += (durationInHours - 8);
                }

            }

            long overtimeAmount = (long) (overtime * salaryPerHour);
            long totalAmount = personnel.getBaseSalary() + overtimeAmount;

            MonthlyCompensation monthlyCompensation = new MonthlyCompensation();
            monthlyCompensation.setPersonnelId(personnel.getId());
            monthlyCompensation.setTotalAmount(totalAmount);
            monthlyCompensation.setOvertimeAmount(overtimeAmount);
            monthlyCompensationRepository.save(monthlyCompensation);
        }

    }
}
