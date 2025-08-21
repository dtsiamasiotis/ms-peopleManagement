package org.hospitalManagement.mspeoplemanagement.persistence.model;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
@Table(name="patients")
@Data
public class Patient {
    @Id
    @GeneratedValue (strategy = GenerationType.SEQUENCE, generator = "patients_generator")
    @SequenceGenerator(name = "patients_generator", sequenceName = "patients_id_seq", allocationSize = 1)
    private Long id;
    private String firstName;
    private String lastName;
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private LocalDate dateOfBirth;
    private String email;
    private Long insuranceNumber;
}
