package za.co.bmw.assessment.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.DateSerializer;
import io.swagger.annotations.ApiModel;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;


@Entity
@Table(name="BMWCARS")
@ApiModel(description="details about BmwCars.")
public class BmwCars {

    @Id
    @GeneratedValue
    private Long id;

    private String carName;
    private Date createdDate;


    public BmwCars() {
        super();
    }

    public BmwCars(Long id, String carName, Date createdDate) {
        super();
        this.id = id;
        this.carName = carName;
        this.createdDate = createdDate;
    }


    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getCarName() {
        return carName;
    }
    public void setCarName(String carName) {
        this.carName = carName;
    }

    @JsonSerialize(using= DateSerializer.class)
    public Date getCreatedDate() {
        return createdDate;
    }
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

}

