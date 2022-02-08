package pl.tm.hardwareinventory.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class TaskUserHardwareSoftwareDTO {

    private long taskId;
    private LocalDate closeDate;
    private String description;
    private LocalDate logDate;
    private int priority;
    private Boolean status;
    private String title;
    //hardware
    private String serialNumber;
    private String hardwareName;
    private String hardwareProducerName;
    //software
    private String softwareProducerName;
    private String softwareName; // software ma też name
    private String username;
}
