package org.hospitalManagement.mspeoplemanagement.api;

import org.hospitalManagement.mspeoplemanagement.persistence.model.Patient;
import org.hospitalManagement.mspeoplemanagement.services.PatientManagementService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PatientController {

    private PatientManagementService patientManagementService;

    public PatientController(PatientManagementService patientManagementService) {
        this.patientManagementService = patientManagementService;
    }

    @GetMapping(value = "/listPatients")
    public List<Patient> listPatients() {
        return patientManagementService.getListOfPatients();
    }

    @GetMapping(value = "/getPatientById")
    public Patient getPatientById(@RequestParam("id") long id) {
        return patientManagementService.getPatientById(id);
    }

    @PostMapping(value = "/createPatient")
    public void createPatient(@RequestBody Patient patient) {
        patientManagementService.createPatient(patient);
    }
}
