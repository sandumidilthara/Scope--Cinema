package lk.ijse.backend.repo;

import lk.ijse.backend.Entity.Booking;
import lk.ijse.backend.Entity.FilmHall;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface BookingRepo extends JpaRepository<Booking,Long> {
}
