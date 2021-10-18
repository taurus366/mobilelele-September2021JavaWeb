package bg.softuni.mobilelele.data.model.view;

import bg.softuni.mobilelele.data.enums.EngineTypeEnum;
import bg.softuni.mobilelele.data.enums.TransmissionTypeEnum;
import bg.softuni.mobilelele.data.model.entity.ModelEntity;
import bg.softuni.mobilelele.data.model.entity.UserEntity;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;

public class OfferSummaryView {

    private long id;
    private String description;
    private EngineTypeEnum engine;
    private String imageUrl;
    private Integer mileage;
    private Integer price;
    private String transmission;
    private int year;
    private String model;

    public long getId() {
        return id;
    }

    public OfferSummaryView setId(long id) {
        this.id = id;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public OfferSummaryView setDescription(String description) {
        this.description = description;
        return this;
    }

    public EngineTypeEnum getEngine() {
        return engine;
    }

    public OfferSummaryView setEngine(EngineTypeEnum engine) {
        this.engine = engine;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public OfferSummaryView setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public Integer getMileage() {
        return mileage;
    }

    public OfferSummaryView setMileage(Integer mileage) {
        this.mileage = mileage;
        return this;
    }

    public Integer getPrice() {
        return price;
    }

    public OfferSummaryView setPrice(Integer price) {
        this.price = price;
        return this;
    }

    public String getTransmission() {
        return transmission;
    }

    public OfferSummaryView setTransmission(String transmission) {
        this.transmission = transmission;
        return this;
    }

    public int getYear() {
        return year;
    }

    public OfferSummaryView setYear(int year) {
        this.year = year;
        return this;
    }

    public String getModel() {
        return model;
    }

    public OfferSummaryView setModel(String model) {
        this.model = model;
        return this;
    }
}
