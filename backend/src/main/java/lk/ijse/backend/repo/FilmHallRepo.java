package lk.ijse.backend.repo;

import lk.ijse.backend.Entity.FilmHall;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface FilmHallRepo extends JpaRepository<FilmHall,Long> {



}
