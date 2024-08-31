package org.hospitalManagement.mspeoplemanagement.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@JsonIgnoreProperties(
        ignoreUnknown = true
)
@Data
public class ClockInOutRequest {
    @NotNull
    private Long personnelId;
}
