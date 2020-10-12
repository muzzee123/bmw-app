package za.co.bmw.assessment.rest;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.net.URI;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import za.co.bmw.assessment.model.BmwCars;
import za.co.bmw.assessment.repository.CarsRepository;

@RestController
@CrossOrigin(origins = "http://localhost:5000")
public class BmwCarsController {

    @Autowired
    private CarsRepository carsRepository;

    @GetMapping("/cars")
    public List<BmwCars> getCars() {
        BmwCars cars = new BmwCars(new Long((long) 1.2), "BMW X5", new Date());
        return carsRepository.findAll();
    }

    @GetMapping("/cars/{id}")
    public EntityModel<BmwCars> getCar(@PathVariable long id) throws Exception {
        Optional<BmwCars> car = carsRepository.findById(id);

        if (!car.isPresent())
            throw new Exception("Car not found");
        EntityModel<BmwCars> carFound = EntityModel.of(car.get());

        return carFound;

    }

    @DeleteMapping("/cars/{id}")
    public void deleteCar(@PathVariable long id) {
        carsRepository.deleteById(id);
    }

    @PostMapping("/cars")
    public ResponseEntity<Object> createCar(@RequestBody BmwCars car) {
        BmwCars savedCar = carsRepository.save(car);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedCar.getId()).toUri();

        return ResponseEntity.created(location).build();

    }

    @PutMapping("/cars/{id}")
    public ResponseEntity<Object> updateCar(@RequestBody BmwCars car, @PathVariable long id) {

        Optional<BmwCars> carOptional = carsRepository.findById(id);

        if (!carOptional.isPresent())
            return ResponseEntity.notFound().build();

        car.setId(id);

        carsRepository.save(car);

        return ResponseEntity.noContent().build();
    }

}


