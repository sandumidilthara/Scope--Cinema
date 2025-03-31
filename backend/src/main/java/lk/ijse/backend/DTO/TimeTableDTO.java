package lk.ijse.backend.DTO;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Objects;

public class TimeTableDTO {




    private Long id;




    private  String description;


    private LocalTime showTime;

    private LocalTime endTime;

    public TimeTableDTO(Long id, String description, LocalTime showTime, LocalTime endTime) {
        this.id = id;
        this.description = description;
        this.showTime = showTime;
        this.endTime = endTime;
    }


    public TimeTableDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalTime getShowTime() {
        return showTime;
    }

    public void setShowTime(LocalTime showTime) {
        this.showTime = showTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }
}
