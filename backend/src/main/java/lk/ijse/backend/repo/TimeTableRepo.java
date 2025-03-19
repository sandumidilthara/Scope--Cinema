package lk.ijse.backend.repo;

import lk.ijse.backend.Entity.TimeTable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TimeTableRepo extends JpaRepository<TimeTable,Long> {
}
