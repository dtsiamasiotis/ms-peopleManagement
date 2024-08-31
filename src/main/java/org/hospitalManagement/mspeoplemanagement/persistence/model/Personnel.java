package org.hospitalManagement.mspeoplemanagement.persistence.model;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="personnel")
@Data
public class Personnel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "personnel_generator")
    @SequenceGenerator(name = "personnel_generator", sequenceName = "personnel_id_seq", allocationSize = 1)
    private Long id;

    private Occupation occupation;
    private Long clinicId;
    private Long baseSalary;
}
