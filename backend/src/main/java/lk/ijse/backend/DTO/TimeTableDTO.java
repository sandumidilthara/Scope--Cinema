package lk.ijse.backend.DTO;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Objects;

public class TimeTableDTO {




    private Long id;




    private  String description;


    private LocalDateTime showTime;

    private LocalDateTime endTime;

    public TimeTableDTO(Long id, String description, LocalDateTime showTime, LocalDateTime endTime) {
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

    public LocalDateTime getShowTime() {
        return showTime;
    }

    public void setShowTime(LocalDateTime showTime) {
        this.showTime = showTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }
}
