package org.hospitalManagement.mspeoplemanagement.persistence.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.ZonedDateTime;

@Entity
@Table(name="workdays")
@Data
public class WorkDay {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "workdays_generator")
    @SequenceGenerator(name = "workdays_generator", sequenceName = "workdays_id_seq", allocationSize = 1)
    private Long id;
    private Long personnelId;
    private ZonedDateTime startTime;
    private ZonedDateTime endTime;
}
