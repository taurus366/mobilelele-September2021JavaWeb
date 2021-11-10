package bg.softuni.mobilelele.data.service;

import bg.softuni.mobilelele.data.model.binding.OfferAddBindingModel;
import bg.softuni.mobilelele.data.model.service.OfferAddServiceModel;
import bg.softuni.mobilelele.data.model.service.OfferUpdateServiceModel;
import bg.softuni.mobilelele.data.model.view.OfferDetailsView;
import bg.softuni.mobilelele.data.model.view.OfferSummaryView;

import java.security.Principal;
import java.util.List;

public interface OfferService {
    void initializedOffers();
    List<OfferSummaryView> getAllOffers();
    OfferDetailsView getOfferById(long id);
    void deleteOffer(Long id);
    void updateOffer(OfferUpdateServiceModel offerModel);
    OfferAddServiceModel addOffer(OfferAddBindingModel offerAddBindingModel, String sellerUsername);
}
