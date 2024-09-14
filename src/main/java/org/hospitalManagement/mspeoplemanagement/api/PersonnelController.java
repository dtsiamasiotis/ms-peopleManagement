package org.hospitalManagement.mspeoplemanagement.api;

import jakarta.validation.Valid;
import org.hospitalManagement.mspeoplemanagement.services.CompensationService;
import org.hospitalManagement.mspeoplemanagement.persistence.model.Personnel;
import org.hospitalManagement.mspeoplemanagement.services.PersonnelManagementService;
import org.hospitalManagement.mspeoplemanagement.services.WorkdaysManagementService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonnelController {

    private PersonnelManagementService personnelManagementService;
    private WorkdaysManagementService workdaysManagementService;
    private CompensationService compensationService;

    public PersonnelController (PersonnelManagementService personnelManagementService, WorkdaysManagementService workdaysManagementService, CompensationService compensationService) {
        this.personnelManagementService = personnelManagementService;
        this.workdaysManagementService = workdaysManagementService;
        this.compensationService = compensationService;
    }

    @GetMapping("/listPersonnel")
    public List<Personnel> listPersonnel() {
        return personnelManagementService.getListOfPersonnel();
    }

    @GetMapping("/getPersonnelById")
    public Personnel getPersonnelById(@RequestParam("id") long id) {
        return personnelManagementService.getPersonnelById(id);
    }

    @PostMapping("/clockIn")
    public void clockIn(@Valid @RequestBody ClockInOutRequest clockInOutRequest) {
        workdaysManagementService.startWorkDay(clockInOutRequest.getPersonnelId());
    }

    @PostMapping("/clockOut")
    public void clockOut(@Valid @RequestBody ClockInOutRequest clockInOutRequest) {
        workdaysManagementService.endWorkDay(clockInOutRequest.getPersonnelId());
    }

    @GetMapping("/calculateMonthlyCompensation")
    public void calculateMonthlyCompensation() {
        compensationService.calculateMonthlyCompensation();
    }
}
