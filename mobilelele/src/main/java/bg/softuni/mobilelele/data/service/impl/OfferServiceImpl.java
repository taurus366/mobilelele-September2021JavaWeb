package bg.softuni.mobilelele.data.service.impl;

import bg.softuni.mobilelele.data.enums.EngineTypeEnum;
import bg.softuni.mobilelele.data.enums.TransmissionTypeEnum;
import bg.softuni.mobilelele.data.model.binding.OfferAddBindingModel;
import bg.softuni.mobilelele.data.model.entity.ModelEntity;
import bg.softuni.mobilelele.data.model.entity.OfferEntity;
import bg.softuni.mobilelele.data.model.entity.UserEntity;
import bg.softuni.mobilelele.data.model.service.OfferAddServiceModel;
import bg.softuni.mobilelele.data.model.service.OfferUpdateServiceModel;
import bg.softuni.mobilelele.data.model.view.OfferDetailsView;
import bg.softuni.mobilelele.data.model.view.OfferSummaryView;
import bg.softuni.mobilelele.data.repository.ModelRepository;
import bg.softuni.mobilelele.data.repository.OfferRepository;
import bg.softuni.mobilelele.data.repository.UserRepository;
import bg.softuni.mobilelele.data.service.OfferService;
import bg.softuni.mobilelele.data.web.exception.ObjectNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OfferServiceImpl implements OfferService {

    private final OfferRepository offerRepository;
    private final ModelMapper modelMapper;
    private final ModelRepository modelRepository;
    private final UserRepository userRepository;

    public OfferServiceImpl(OfferRepository offerRepository, ModelMapper modelMapper, ModelRepository modelRepository, UserRepository userRepository) {
        this.offerRepository = offerRepository;
        this.modelMapper = modelMapper;
        this.modelRepository = modelRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void initializedOffers() {
       if (offerRepository.count() == 0){
           OfferEntity offer1 = new OfferEntity();

           offer1.setDescription("testDescription")
                   .setEngine(EngineTypeEnum.DIESEL)
                   .setImageUrl("https://lh3.googleusercontent.com/proxy/FeRVYXyR_3nDJp-1bjuOtwiRssnS_aF8BnOZcjRME0_OucFv2G8p1N1jlPT-DGmkHbPMqJ7K4rFL1S9ac0pkdQ")
                   .setMileage(200000)
                   .setModel(modelRepository.findById(1L).orElse(null))
                   .setPrice(222)
                   .setSeller(userRepository.findByUsername("taurus366").get())
                   .setTransmission(TransmissionTypeEnum.AUTOMATIC)
                   .setYear(1995);
           offerRepository.save(offer1);

           OfferEntity offer2 = new OfferEntity();

           offer2.setDescription("testDescription")
                   .setEngine(EngineTypeEnum.DIESEL)
                   .setImageUrl("http://images.unsplash.com/flagged/photo-1553505192-acca7d4509be?ixlib=rb-1.2.1&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=1080&fit=max")
                   .setMileage(2000)
                   .setModel(modelRepository.findById(2L).orElse(null))
                   .setPrice(233322)
                   .setSeller(userRepository.findByUsername("taurus366").get())
                   .setTransmission(TransmissionTypeEnum.AUTOMATIC)
                   .setYear(2021);
           offerRepository.save(offer2);
       }
    }

    @Override
    public List<OfferSummaryView> getAllOffers() {
        return offerRepository.findAll().stream().map(this::offerSummaryViewMap).collect(Collectors.toList());

    }

    @Override
    public OfferDetailsView getOfferById(long id) {

        OfferEntity offerEntity = offerRepository.findById(id).orElse(null);
//        OfferSummaryView map = modelMapper.map(offerEntity, OfferSummaryView.class);

        return offerRepository.findById(id).map(this::offerDetailViewMap).orElse(null);
    }

    @Override
    public void deleteOffer(Long id) {
        offerRepository.deleteById(id);
    }

    @Override
    public void updateOffer(OfferUpdateServiceModel offerModel) {

        OfferEntity offerEntity = offerRepository.findById(offerModel.getId()).orElseThrow(() -> new ObjectNotFoundException("Offer with id " + offerModel.getId() + " not found"));
        System.out.println(offerModel.getEngine());
        offerEntity
                .setPrice(offerModel.getPrice())
                .setDescription(offerModel.getDescription())
                .setEngine(offerModel.getEngine())
                .setImageUrl(offerModel.getImageUrl())
                .setMileage(offerModel.getMileage())
                .setTransmission(offerModel.getTransmission())
                .setYear(offerModel.getYear())
                .setModified(Instant.now());

        offerRepository.save(offerEntity);
    }

//    @Override
//    public OfferAddServiceModel addOffer(OfferAddBindingModel offerAddBindingModel, Principal principal) {
//        return null;
//    }

    @Override
    public OfferAddServiceModel addOffer(OfferAddBindingModel offerAddBindingModel, String sellerUsername) {
//        UserEntity userEntity = userRepository.findByUsername(ownerId).orElseThrow();

        OfferAddServiceModel offerAddServiceModel = modelMapper.map(offerAddBindingModel, OfferAddServiceModel.class);

        OfferEntity newOffer = modelMapper.map(offerAddServiceModel, OfferEntity.class);

        newOffer.setCreated(Instant.now());
//        newOffer.setSeller(userEntity);
        newOffer.setSeller(userRepository.findByUsername(sellerUsername).orElseThrow());

        ModelEntity model = modelRepository.getById(offerAddBindingModel.getModelId());

        newOffer.setModel(model);

        OfferEntity savedOffer = offerRepository.save(newOffer);

        return modelMapper.map(savedOffer, OfferAddServiceModel.class);
    }

    private OfferSummaryView offerSummaryViewMap(OfferEntity offerEntity) {
        //TODO
        OfferSummaryView summaryView = this.modelMapper.map(offerEntity, OfferSummaryView.class);

//        System.out.printf("%s %s %s %s %s %s %s %s %s",summaryView.getDescription(),summaryView.getEngine(),summaryView.getId()
//                ,summaryView.getModel(),summaryView.getMileage(),summaryView.getImageUrl(),summaryView.getPrice(),summaryView.getTransmission(),
//                summaryView.getYear());

        summaryView.setModel(offerEntity.getModel().getName());

        return summaryView;
    }

    private OfferDetailsView offerDetailViewMap(OfferEntity offerEntity) {
        //TODO
        OfferDetailsView offerDetailsView = this.modelMapper.map(offerEntity, OfferDetailsView.class);

//        System.out.printf("%s %s %s %s %s %s %s %s %s",summaryView.getDescription(),summaryView.getEngine(),summaryView.getId()
//                ,summaryView.getModel(),summaryView.getMileage(),summaryView.getImageUrl(),summaryView.getPrice(),summaryView.getTransmission(),
//                summaryView.getYear());

        offerDetailsView.setModel(offerEntity.getModel().getName());
        offerDetailsView.setSellerFullName(offerEntity.getSeller().getFirstName()+" "+offerEntity.getSeller().getLastName());
        offerDetailsView.setBrand(offerEntity.getModel().getBrand().getName());
        return offerDetailsView;
    }


}
