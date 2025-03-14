package lk.ijse.backend.DTO;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Objects;

public class TimeTableDTO {


    private Long id;


    private LocalDateTime showTime;


    private LocalDateTime endTime;


    private Double price;


    private boolean isAvailable = true;


    private FilmDTO filmDTO;


    private FilmHallDTO filmHallDTO;

    // Constructors
    public TimeTableDTO() {
    }

    public TimeTableDTO(LocalDateTime showTime, LocalDateTime endTime, Double price,
                        boolean isAvailable, FilmDTO filmDTO, FilmHallDTO filmHallDTO) {
        this.showTime = showTime;
        this.endTime = endTime;
        this.price = price;
        this.isAvailable = isAvailable;
        this.filmDTO = filmDTO;
        this.filmHallDTO = filmHallDTO;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public FilmDTO getFilm() {
        return filmDTO;
    }

    public void setFilm(FilmDTO filmDTO) {
        this.filmDTO = filmDTO;
    }

    public FilmHallDTO getFilmHall() {
        return filmHallDTO;
    }

    public void setFilmHall(FilmHallDTO filmHallDTO) {
        this.filmHallDTO = filmHallDTO;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TimeTableDTO timeTableDTO = (TimeTableDTO) o;
        return Objects.equals(id, timeTableDTO.id) &&
                Objects.equals(showTime, timeTableDTO.showTime) &&
                Objects.equals(filmDTO, timeTableDTO.filmDTO) &&
                Objects.equals(filmHallDTO, timeTableDTO.filmHallDTO);
    }
}
