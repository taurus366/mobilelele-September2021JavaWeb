package bg.softuni.mobilelele.data.model.view;

import bg.softuni.mobilelele.data.enums.EngineTypeEnum;
import bg.softuni.mobilelele.data.enums.TransmissionTypeEnum;

import java.time.Instant;

public class OfferDetailsView {
    private String description;
    private EngineTypeEnum engineTypeEnum;
    private Instant created;
    private Instant modified;
    private String imageUrl;
    private int mileage;
    private String sellerFullName;
    private int price;
    private TransmissionTypeEnum transmission;
    private int year;
    private String model;
    private String brand;
    private Long id;

    public OfferDetailsView() {
    }

    public String getDescription() {
        return description;
    }

    public OfferDetailsView setDescription(String description) {
        this.description = description;
        return this;
    }

    public EngineTypeEnum getEngineTypeEnum() {
        return engineTypeEnum;
    }

    public OfferDetailsView setEngineTypeEnum(EngineTypeEnum engineTypeEnum) {
        this.engineTypeEnum = engineTypeEnum;
        return this;
    }

    public Instant getCreated() {
        return created;
    }

    public OfferDetailsView setCreated(Instant created) {
        this.created = created;
        return this;
    }

    public Instant getModified() {
        return modified;
    }

    public OfferDetailsView setModified(Instant modified) {
        this.modified = modified;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public OfferDetailsView setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public int getMileage() {
        return mileage;
    }

    public OfferDetailsView setMileage(int mileage) {
        this.mileage = mileage;
        return this;
    }

    public String getSellerFullName() {
        return sellerFullName;
    }

    public OfferDetailsView setSellerFullName(String sellerFullName) {
        this.sellerFullName = sellerFullName;
        return this;
    }

    public int getPrice() {
        return price;
    }

    public OfferDetailsView setPrice(int price) {
        this.price = price;
        return this;
    }

    public TransmissionTypeEnum getTransmission() {
        return transmission;
    }

    public OfferDetailsView setTransmission(TransmissionTypeEnum transmission) {
        this.transmission = transmission;
        return this;
    }

    public int getYear() {
        return year;
    }

    public OfferDetailsView setYear(int year) {
        this.year = year;
        return this;
    }

    public String getModel() {
        return model;
    }

    public OfferDetailsView setModel(String model) {
        this.model = model;
        return this;
    }

    public String getBrand() {
        return brand;
    }

    public OfferDetailsView setBrand(String brand) {
        this.brand = brand;
        return this;
    }

    public Long getId() {
        return id;
    }

    public OfferDetailsView setId(Long id) {
        this.id = id;
        return this;
    }
}
