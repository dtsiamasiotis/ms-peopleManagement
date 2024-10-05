package org.hospitalManagement.mspeoplemanagement.persistence.model;

import jakarta.persistence.*;
import lombok.Data;

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
    private String email;
    private Long insuranceNumber;
}
