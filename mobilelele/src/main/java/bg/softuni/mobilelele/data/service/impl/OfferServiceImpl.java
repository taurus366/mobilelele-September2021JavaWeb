package bg.softuni.mobilelele.data.service.impl;

import bg.softuni.mobilelele.data.model.entity.OfferEntity;
import bg.softuni.mobilelele.data.model.view.OfferSummaryView;
import bg.softuni.mobilelele.data.repository.OfferRepository;
import bg.softuni.mobilelele.data.service.OfferService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OfferServiceImpl implements OfferService {

    private final OfferRepository offerRepository;

    public OfferServiceImpl(OfferRepository offerRepository) {
        this.offerRepository = offerRepository;
    }

    @Override
    public void initializedOffers() {

    }

    @Override
    public List<OfferSummaryView> getAllOffers() {
        return offerRepository.findAll().stream().map(this::map).collect(Collectors.toList());

    }
    private OfferSummaryView map(OfferEntity offerEntity){
        //TODO
        return new OfferSummaryView();
    }
}
