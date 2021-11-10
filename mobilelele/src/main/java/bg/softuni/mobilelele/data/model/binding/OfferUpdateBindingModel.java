package bg.softuni.mobilelele.data.model.binding;

import bg.softuni.mobilelele.data.model.entity.enums.EngineEnum;
import bg.softuni.mobilelele.data.model.entity.enums.TransmissionEnum;
import org.springframework.beans.factory.annotation.Value;

import javax.validation.constraints.*;

public class OfferUpdateBindingModel {

    private Long id;

    @NotBlank
    private String description;

    @NotNull
    private EngineEnum engine;

    @NotBlank
    private String imageUrl;

    @NotNull
    @PositiveOrZero
    private Integer mileage;

    @NotNull
    @Min(100)
    private Integer price;

    @NotNull
    private EngineEnum transmission;

    @NotNull
    @Min(1930)
    private Integer year;

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

    public EngineEnum getEngine() {
        return engine;
    }

    public OfferUpdateBindingModel setEngine(EngineEnum engine) {
        this.engine = engine;
        return this;
    }

    public OfferUpdateBindingModel setMileage(Integer mileage) {
        this.mileage = mileage;
        return this;
    }

    public OfferUpdateBindingModel setPrice(Integer price) {
        this.price = price;
        return this;
    }

    public EngineEnum getTransmission() {
        return transmission;
    }

    public OfferUpdateBindingModel setTransmission(EngineEnum transmission) {
        this.transmission = transmission;
        return this;
    }

    public OfferUpdateBindingModel setYear(Integer year) {
        this.year = year;
        return this;
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



    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
