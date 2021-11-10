package bg.softuni.mobilelele.data.model.service;

import bg.softuni.mobilelele.data.model.entity.enums.EngineEnum;
import bg.softuni.mobilelele.data.model.entity.enums.TransmissionEnum;

import java.time.Instant;

public class OfferUpdateServiceModel {

    private String description;
    private EngineEnum engine;
    private Instant created;
    private Instant modified;
    private String imageUrl;
    private int mileage;
    private String sellerFullName;
    private int price;
    private TransmissionEnum transmission;
    private int year;
    private String model;
    private String brand;
    private Long id;

    public OfferUpdateServiceModel() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public EngineEnum getEngine() {
        return engine;
    }

    public OfferUpdateServiceModel setEngine(EngineEnum engine) {
        this.engine = engine;
        return this;
    }

    public TransmissionEnum getTransmission() {
        return transmission;
    }

    public OfferUpdateServiceModel setTransmission(TransmissionEnum transmission) {
        this.transmission = transmission;
        return this;
    }

    public Instant getCreated() {
        return created;
    }

    public void setCreated(Instant created) {
        this.created = created;
    }

    public Instant getModified() {
        return modified;
    }

    public void setModified(Instant modified) {
        this.modified = modified;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public String getSellerFullName() {
        return sellerFullName;
    }

    public void setSellerFullName(String sellerFullName) {
        this.sellerFullName = sellerFullName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }



    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
