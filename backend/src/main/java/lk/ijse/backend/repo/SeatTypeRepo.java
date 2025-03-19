package lk.ijse.backend.repo;

import lk.ijse.backend.Entity.SeatType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SeatTypeRepo extends JpaRepository<SeatType,Long> {

    Optional<SeatType> findById(Long id);
}
