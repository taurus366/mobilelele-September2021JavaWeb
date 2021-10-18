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

    public OfferEntity setDescription(String description) {
        this.description = description;
        return this;
    }

    public EngineTypeEnum getEngine() {
        return engine;
    }

    public OfferEntity setEngine(EngineTypeEnum engine) {
        this.engine = engine;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public OfferEntity setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public Integer getMileage() {
        return mileage;
    }

    public OfferEntity setMileage(Integer mileage) {
        this.mileage = mileage;
        return this;
    }

    public Integer getPrice() {
        return price;
    }

    public OfferEntity setPrice(Integer price) {
        this.price = price;
        return this;
    }

    public TransmissionTypeEnum getTransmission() {
        return transmission;
    }

    public OfferEntity setTransmission(TransmissionTypeEnum transmission) {
        this.transmission = transmission;
        return this;
    }

    public int getYear() {
        return year;
    }

    public OfferEntity setYear(int year) {
        this.year = year;
        return this;
    }

    public ModelEntity getModel() {
        return model;
    }

    public OfferEntity setModel(ModelEntity model) {
        this.model = model;
        return this;
    }

    public UserEntity getSeller() {
        return seller;
    }

    public OfferEntity setSeller(UserEntity seller) {
        this.seller = seller;
        return this;
    }
}
