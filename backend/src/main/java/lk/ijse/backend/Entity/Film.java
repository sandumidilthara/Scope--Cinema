package lk.ijse.backend.Entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "films")
public class Film {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(length = 1000)
    private String description;

    @Column
    private String genre;

    @Column
    private String director;

    @Column(name = "duration_minutes")
    private Integer durationMinutes;

    @Column(name = "release_date")
    private LocalDate releaseDate;

    @Column
    private String language;

    @Column(name = "poster_url")
    private String posterUrl;

    @Column(name = "is_active")
    private boolean isActive = true;

    @OneToMany(mappedBy = "film")
    private List<TimeTable> timeTables;

    @OneToMany(mappedBy = "film")
    private List<User> users;

    @ManyToOne
    @JoinColumn(name = "film_hall_id")
    private FilmHall filmHall;


    @Column( name = "film_photo")
    private String imageUrl;


    @Column( name = "trailer")
    private String trailerUrl;



    // Constructors
    public Film() {
    }

    public Film(Long id, String title, String description, String genre, String director, Integer durationMinutes, LocalDate releaseDate, String language, String posterUrl, boolean isActive, List<TimeTable> timeTables, List<User> users, FilmHall filmHall, String imageUrl, String trailerUrl) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.genre = genre;
        this.director = director;
        this.durationMinutes = durationMinutes;
        this.releaseDate = releaseDate;
        this.language = language;
        this.posterUrl = posterUrl;
        this.isActive = isActive;
        this.timeTables = timeTables;
        this.users = users;
        this.filmHall = filmHall;
        this.imageUrl = imageUrl;
        this.trailerUrl = trailerUrl;
    }


    public String getTrailerUrl() {
        return trailerUrl;
    }

    public void setTrailerUrl(String trailerUrl) {
        this.trailerUrl = trailerUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public Integer getDurationMinutes() {
        return durationMinutes;
    }

    public void setDurationMinutes(Integer durationMinutes) {
        this.durationMinutes = durationMinutes;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getPosterUrl() {
        return posterUrl;
    }

    public void setPosterUrl(String posterUrl) {
        this.posterUrl = posterUrl;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public List<TimeTable> getTimeTables() {
        return timeTables;
    }

    public void setTimeTables(List<TimeTable> timeTables) {
        this.timeTables = timeTables;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public FilmHall getFilmHall() {
        return filmHall;
    }

    public void setFilmHall(FilmHall filmHall) {
        this.filmHall = filmHall;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Film film = (Film) o;
        return Objects.equals(id, film.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Film{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", genre='" + genre + '\'' +
                ", durationMinutes=" + durationMinutes +
                '}';
    }
}


