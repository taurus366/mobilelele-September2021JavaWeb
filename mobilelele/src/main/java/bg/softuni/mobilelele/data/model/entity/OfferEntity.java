package bg.softuni.mobilelele.data.model.entity;

import bg.softuni.mobilelele.data.enums.EngineTypeEnum;
import bg.softuni.mobilelele.data.enums.TransmissionTypeEnum;
import org.springframework.stereotype.Controller;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "offers")
public class OfferEntity extends BaseEntity {
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private EngineTypeEnum engine;
    @Column(nullable = false)
    private String imageUrl;
    private Integer mileage;
    private Integer price;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private TransmissionTypeEnum transmission;
    private int year;
    @ManyToOne
    private ModelEntity model;
    @ManyToOne
    private UserEntity seller;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public EngineTypeEnum getEngine() {
        return engine;
    }

    public void setEngine(EngineTypeEnum engine) {
        this.engine = engine;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Integer getMileage() {
        return mileage;
    }

    public void setMileage(Integer mileage) {
        this.mileage = mileage;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public TransmissionTypeEnum getTransmission() {
        return transmission;
    }

    public void setTransmission(TransmissionTypeEnum transmission) {
        this.transmission = transmission;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public ModelEntity getModel() {
        return model;
    }

    public void setModel(ModelEntity model) {
        this.model = model;
    }

    public UserEntity getSeller() {
        return seller;
    }

    public void setSeller(UserEntity seller) {
        this.seller = seller;
    }
}
