package bg.softuni.mobilelele.data.web;

import bg.softuni.mobilelele.data.service.OfferService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class OfferController {

   private final OfferService offerService;

    public OfferController(OfferService offerService) {
        this.offerService = offerService;
    }


    @GetMapping("/offers/all")
    public String allOffers(Model model) {
        model.addAttribute("offers",offerService.getAllOffers());
        return "offers";
    }

    @GetMapping("/offers/{id}/details")
    public String showOffer(@PathVariable long id, Model model){
        model.addAttribute("offer",offerService.getOfferById(id));
        return "details";
    }

}
