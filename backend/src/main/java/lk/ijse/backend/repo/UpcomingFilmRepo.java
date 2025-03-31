package lk.ijse.backend.repo;

import lk.ijse.backend.Entity.Film;
import lk.ijse.backend.Entity.UpcomingFilm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface UpcomingFilmRepo extends JpaRepository<UpcomingFilm, UUID> {
}
