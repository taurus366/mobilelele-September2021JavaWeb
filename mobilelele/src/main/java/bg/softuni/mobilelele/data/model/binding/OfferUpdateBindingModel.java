package bg.softuni.mobilelele.data.model.binding;

import bg.softuni.mobilelele.data.enums.EngineTypeEnum;
import bg.softuni.mobilelele.data.enums.TransmissionTypeEnum;

import java.time.Instant;

public class OfferUpdateBindingModel {

    private Long id;
    private String description;
    private EngineTypeEnum engineTypeEnum;
    private String imageUrl;
    private int mileage;
    private int price;
    private TransmissionTypeEnum transmission;
    private int year;

    public OfferUpdateBindingModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public EngineTypeEnum getEngineTypeEnum() {
        return engineTypeEnum;
    }

    public void setEngineTypeEnum(EngineTypeEnum engineTypeEnum) {
        this.engineTypeEnum = engineTypeEnum;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
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
}
