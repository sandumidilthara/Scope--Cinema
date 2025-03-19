package lk.ijse.backend.repo;

import lk.ijse.backend.Entity.FilmRegistration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;
@Repository
public interface FilmRegistrationRepo extends JpaRepository<FilmRegistration, Long> {

    @Modifying
    @Transactional
    @Query("DELETE FROM FilmRegistration fr WHERE fr.id = :id")
    void deleteFilmRegistrationById(@Param("id") Long id);
}


