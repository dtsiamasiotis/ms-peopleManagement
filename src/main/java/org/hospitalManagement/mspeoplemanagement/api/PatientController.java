package org.hospitalManagement.mspeoplemanagement.api;

import org.hospitalManagement.mspeoplemanagement.persistence.model.Patient;
import org.hospitalManagement.mspeoplemanagement.services.PatientManagementService;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    public Optional<Patient> getPatientById(@RequestParam("id") long id) {
        return patientManagementService.getPatientById(id);
    }

    @PostMapping(value = "/createPatient")
    public void createPatient(@RequestBody Patient patient) {
        patientManagementService.createPatient(patient);
    }

    @GetMapping(value = "/getPatientByInsuranceNumber")
    public ResponseEntity<Patient> getPatientByInsuranceNumber(@RequestParam("insuranceNumber") long insuranceNumber) {
        return patientManagementService.getPatientByInsuranceNumber(insuranceNumber).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
