package za.co.bmw.assessment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.co.bmw.assessment.model.BmwCars;

@Repository
public interface CarsRepository extends JpaRepository<BmwCars, Long> {
}

