package lk.ijse.backend.Entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "film_halls")
public class FilmHall {

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(name = "total_capacity")
    private Integer totalCapacity;

    @Column
    private String location;

    @Column
    private String description;

    @Column(name = "hall_type")
    private String hallType; // Regular, IMAX, VIP, etc.



    @Column( name = "filmHall_photo")
    private String image;



    @OneToMany(mappedBy = "filmHall", cascade = CascadeType.ALL)
    private List<Seats> seats;

    @OneToMany(mappedBy = "filmHall")
    private List<TimeTable> timeTables;

    @OneToMany(mappedBy = "filmHall")
    private List<Film> films;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTotalCapacity() {
        return totalCapacity;
    }

    public void setTotalCapacity(Integer totalCapacity) {
        this.totalCapacity = totalCapacity;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getHallType() {
        return hallType;
    }

    public void setHallType(String hallType) {
        this.hallType = hallType;
    }



    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }


    public FilmHall() {
    }

    public FilmHall(Long id, String name, Integer totalCapacity, String location, String description, String hallType ,String image) {
        this.id = id;
        this.name = name;
        this.totalCapacity = totalCapacity;
        this.location = location;
        this.description = description;
        this.hallType = hallType;
        this.image = image;
    }
}
