package lk.ijse.backend.repo;

import lk.ijse.backend.Entity.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface ExampleRepo extends JpaRepository<Example, UUID> {






}
