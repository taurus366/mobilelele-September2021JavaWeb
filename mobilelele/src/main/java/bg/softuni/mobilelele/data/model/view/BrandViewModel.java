package bg.softuni.mobilelele.data.model.view;

import java.util.ArrayList;
import java.util.List;

public class BrandViewModel {

    private String name;
    private List<ModelViewModel> models = new ArrayList<>();

    public String getName() {
        return name;
    }

    public BrandViewModel setName(String name) {
        this.name = name;
        return this;
    }

    public List<ModelViewModel> getModels() {
        return models;
    }

    public BrandViewModel setModels(List<ModelViewModel> models) {
        this.models = models;
        return this;
    }

    public BrandViewModel addModel(ModelViewModel model){
        if (this.models.size() == 0){
            this.models = new ArrayList<>();
        }
        this.models.add(model);
        return this;
    }
}
