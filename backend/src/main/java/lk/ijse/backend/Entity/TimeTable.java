package lk.ijse.backend.Entity;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "time_tables")
public class TimeTable {

    @Id

    private Long id;



    @Column(name = "description" )
    private  String description;

    @Column(name = "show_time", nullable = false)
    private LocalTime showTime;

    @Column(name = "end_time")
    private LocalTime endTime;





    @OneToMany(fetch = FetchType.EAGER, mappedBy = "timeTable", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<FilmRegistration> filmRegistrationList;

    // Constructors
    public TimeTable() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public List<FilmRegistration> getFilmRegistrationList() {
        return filmRegistrationList;
    }

    public void setFilmRegistrationList(List<FilmRegistration> filmRegistrationList) {
        this.filmRegistrationList = filmRegistrationList;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TimeTable(Long id, String description, LocalTime showTime, LocalTime endTime) {
        this.id = id;
        this.description = description;
        this.showTime = showTime;
        this.endTime = endTime;
        this.filmRegistrationList =  new ArrayList<>();
    }
}
