package bg.softuni.mobilelele.data.web;

import bg.softuni.mobilelele.data.enums.EngineTypeEnum;
import bg.softuni.mobilelele.data.enums.TransmissionTypeEnum;
import bg.softuni.mobilelele.data.model.binding.OfferUpdateBindingModel;
import bg.softuni.mobilelele.data.model.service.OfferUpdateServiceModel;
import bg.softuni.mobilelele.data.model.view.OfferDetailsView;
import bg.softuni.mobilelele.data.service.OfferService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class OfferController {

   private final OfferService offerService;
   private final ModelMapper modelMapper;

    public OfferController(OfferService offerService, ModelMapper modelMapper) {
        this.offerService = offerService;
        this.modelMapper = modelMapper;
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

    @DeleteMapping("/offers/{id}")
    public String deleteOffer(@PathVariable Long id){
        offerService.deleteOffer(id);

        return "redirect:/offers/all";
    }

    @GetMapping("/offers/{id}/edit")
    public String editOffer(@PathVariable Long id,Model model){

        OfferDetailsView offerById = offerService.getOfferById(id);

        OfferUpdateServiceModel map = modelMapper.map(offerById, OfferUpdateServiceModel.class);
        map.setId(id);

        model
                .addAttribute("offerModel", map)
                .addAttribute("engines", EngineTypeEnum.values())
                .addAttribute("transmissions", TransmissionTypeEnum.values());

        return "update";
    }

    @GetMapping("/offers/{id}/edit/errors")
    public String editOfferErrors(@PathVariable Long id,Model model){

        model
                .addAttribute("engines", EngineTypeEnum.values())
                .addAttribute("transmissions", TransmissionTypeEnum.values());

        return "update";
    }

    @PatchMapping("/offers/{id}/edit")
    public String editOffer(@PathVariable Long id, @Valid OfferUpdateBindingModel offerModel, BindingResult bindingResult , RedirectAttributes redirectAttributes){


        if (bindingResult.hasErrors()){
            redirectAttributes
                    .addFlashAttribute("offerModel",offerModel)
                    .addFlashAttribute("org.springframework.validation.BindingResult.offerModel",bindingResult);
            System.out.println("asdasdsa");
            return "redirect:/offers/" + id + "/edit/errors";
        }

        OfferUpdateServiceModel serviceModel = modelMapper.map(offerModel, OfferUpdateServiceModel.class);

        offerService.updateOffer(serviceModel);

        return "redirect:/offers/" + id + "/details";
    }

}
