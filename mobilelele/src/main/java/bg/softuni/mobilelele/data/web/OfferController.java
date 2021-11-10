package bg.softuni.mobilelele.data.web;

import bg.softuni.mobilelele.data.enums.EngineTypeEnum;
import bg.softuni.mobilelele.data.enums.TransmissionTypeEnum;
import bg.softuni.mobilelele.data.model.binding.OfferAddBindingModel;
import bg.softuni.mobilelele.data.model.binding.OfferUpdateBindingModel;
import bg.softuni.mobilelele.data.model.service.OfferAddServiceModel;
import bg.softuni.mobilelele.data.model.service.OfferUpdateServiceModel;
import bg.softuni.mobilelele.data.model.view.OfferDetailsView;
import bg.softuni.mobilelele.data.service.BrandService;
import bg.softuni.mobilelele.data.service.OfferService;
import bg.softuni.mobilelele.data.service.impl.MobileleUser;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.security.Principal;

@Controller
@RequestMapping("/offers")
public class OfferController {

   private final OfferService offerService;
   private final ModelMapper modelMapper;
   private final BrandService brandService;

    public OfferController(OfferService offerService, ModelMapper modelMapper, BrandService brandService) {
        this.offerService = offerService;
        this.modelMapper = modelMapper;
        this.brandService = brandService;
    }


    @GetMapping("/add")
    public String addOfferView(Model model) {

        model
                .addAttribute("brandsWithModels",brandService.getAllBrands());

        return "offer-add";
    }

    @ModelAttribute
    public OfferAddBindingModel offerAddBindingModel(){
        return new OfferAddBindingModel();
    }

    @PostMapping("/add")
    public String addOffer(@Valid OfferAddBindingModel offerAddBindingModel, BindingResult bindingResult, RedirectAttributes redirectAttributes,
                           @AuthenticationPrincipal MobileleUser principal){

        if (bindingResult.hasErrors()){
            redirectAttributes
                    .addFlashAttribute("offerAddBindingModel", offerAddBindingModel)
                    .addFlashAttribute("org.springframework.validation.BindingResult.offerAddBindingModel", bindingResult)
                    .addFlashAttribute("brandsModels", brandService.getAllBrands());
            return "redirect:/offers/add";
        }
        System.out.println(principal.getUserIdentifierName());
//        OfferAddServiceModel savedOfferAddServiceModel = offerService.addOffer(offerAddBindModel, user.getUserIdentifier());
//        return "redirect:/offers/" + savedOfferAddServiceModel.getId() + "/details";
        OfferAddServiceModel offerAddServiceModel = offerService.addOffer(offerAddBindingModel, principal.getUserIdentifierName());
        return "redirect:/offers/"+ offerAddServiceModel.getId() +"/details";
    }

    @GetMapping("/all")
    public String allOffers(Model model) {
        model.addAttribute("offers",offerService.getAllOffers());
        return "offers";
    }

    @GetMapping("/{id}/details")
    public String showOffer(@PathVariable long id, Model model){
        model.addAttribute("offer",offerService.getOfferById(id));
        return "details";
    }

    @DeleteMapping("/{id}")
    public String deleteOffer(@PathVariable Long id){
        offerService.deleteOffer(id);

        return "redirect:/offers/all";
    }

    @GetMapping("/{id}/edit")
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

    @GetMapping("/{id}/edit/errors")
    public String editOfferErrors(@PathVariable Long id,Model model){

        model
                .addAttribute("engines", EngineTypeEnum.values())
                .addAttribute("transmissions", TransmissionTypeEnum.values());

        return "update";
    }

    @PatchMapping("/{id}/edit")
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
