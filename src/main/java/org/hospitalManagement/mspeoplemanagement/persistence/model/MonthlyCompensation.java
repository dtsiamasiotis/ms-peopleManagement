package org.hospitalManagement.mspeoplemanagement.persistence.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "monthlyCompensations")
@Data
public class MonthlyCompensation {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "monthlycompensations_generator")
    @SequenceGenerator(name = "monthlycompensations_generator", sequenceName = "monthlycompesations_id_seq", allocationSize = 1)
    private Long id;
}
