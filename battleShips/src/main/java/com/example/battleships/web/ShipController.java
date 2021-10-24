package com.example.battleships.web;

import com.example.battleships.model.binding.AddShipBindingModel;
import com.example.battleships.model.binding.ShipAttackBindingModel;
import com.example.battleships.model.service.ShipServiceModel;
import com.example.battleships.service.ShipService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/ships")
public class ShipController {

    private final ShipService shipService;
    private final ModelMapper modelMapper;

    public ShipController(ShipService shipService, ModelMapper modelMapper) {
        this.shipService = shipService;
        this.modelMapper = modelMapper;
    }

    @ModelAttribute
    public AddShipBindingModel addShipBindingModel(){
        return new AddShipBindingModel();
    }

    @GetMapping("/add")
    public String addShip(){
        return "ship-add";
    }

    @PostMapping("/add")
    public String addShipConfirm(@Valid AddShipBindingModel addShipBindingModel, BindingResult bindingResult, RedirectAttributes redirectAttributes){

        if (bindingResult.hasErrors()){
            redirectAttributes
                    .addFlashAttribute("addShipBindingModel",addShipBindingModel)
                    .addFlashAttribute("org.springframework.validation.BindingResult.addShipBindingModel",bindingResult);

            return "redirect:add";
        }


        shipService.addShip(modelMapper.map(addShipBindingModel, ShipServiceModel.class));

        return "redirect:/";
    }

    @ModelAttribute
    public ShipAttackBindingModel shipAttackBindingModel(){
        return new ShipAttackBindingModel();
    }

    @PostMapping("/attack")
    public String shipsAttack(@Valid ShipAttackBindingModel shipAttackBindingModel,BindingResult bindingResult,RedirectAttributes redirectAttributes){

        if (bindingResult.hasErrors()){
            redirectAttributes
                    .addFlashAttribute("shipAttackBindingModel",shipAttackBindingModel)
                    .addFlashAttribute("org.springframework.validation.BindingModel.shipAttackBindingModel",bindingResult);
            System.out.println("here");
            System.out.println(shipAttackBindingModel.getAttacker() + "-----------------------------------------------------------------------------------------------------------------");
            System.out.println(shipAttackBindingModel.getDefender() + "-----------------------------------------------------------------------------------------------------------------");

            return "redirect:/";
        }
        System.out.println(shipAttackBindingModel.getAttacker() + "-----------------------------------------------------------------------------------------------------------------");
        shipService.attackShips(shipAttackBindingModel.getAttacker(),shipAttackBindingModel.getDefender());

        return "redirect:/";
    }


}
