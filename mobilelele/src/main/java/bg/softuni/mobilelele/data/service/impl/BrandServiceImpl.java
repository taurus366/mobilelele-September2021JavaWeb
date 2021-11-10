package bg.softuni.mobilelele.data.service.impl;

import bg.softuni.mobilelele.data.model.entity.BrandEntity;
import bg.softuni.mobilelele.data.model.entity.ModelEntity;
import bg.softuni.mobilelele.data.model.view.BrandViewModel;
import bg.softuni.mobilelele.data.model.view.ModelViewModel;
import bg.softuni.mobilelele.data.repository.BrandRepository;
import bg.softuni.mobilelele.data.service.BrandService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BrandServiceImpl implements BrandService {

    private final BrandRepository brandRepository;
    private final ModelMapper modelMapper;

    public BrandServiceImpl(BrandRepository brandRepository, ModelMapper modelMapper) {
        this.brandRepository = brandRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<BrandViewModel> getAllBrands() {
        return brandRepository
                .findAll()
                .stream()
                .map(brandEntity -> {
                    BrandViewModel brandViewModel = new BrandViewModel();
                    brandViewModel.setName(brandEntity.getName());
                    brandViewModel.setModels(brandEntity.getModels()
                            .stream()
//                            .map(modelEntity -> modelMapper.map(modelEntity,ModelViewModel.class))
                                    .map(this::model)
                            .collect(Collectors.toList()));
                    return brandViewModel;
                })
                .collect(Collectors.toList());
    }

    private ModelViewModel model(ModelEntity modelEntity){
        return modelMapper.map(modelEntity,ModelViewModel.class);
    }
}
