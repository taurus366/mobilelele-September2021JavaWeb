package bg.softuni.cloudinary.model.view;

public class PictureViewModel {

    private String title;
    private String publicID;
    private String url;

    public String getTitle() {
        return title;
    }

    public PictureViewModel setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getPublicID() {
        return publicID;
    }

    public PictureViewModel setPublicID(String publicID) {
        this.publicID = publicID;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public PictureViewModel setUrl(String url) {
        this.url = url;
        return this;
    }
}
