package lk.ijse.backend.repo;

import lk.ijse.backend.Entity.Seats;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeatRepo extends JpaRepository<Seats ,Long> {


}
