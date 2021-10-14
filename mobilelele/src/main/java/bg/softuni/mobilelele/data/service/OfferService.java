package bg.softuni.mobilelele.data.service;

import bg.softuni.mobilelele.data.model.view.OfferSummaryView;

import java.util.List;

public interface OfferService {
    void initializedOffers();
    List<OfferSummaryView> getAllOffers();
}
