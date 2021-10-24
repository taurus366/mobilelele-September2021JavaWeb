package com.example.battleships.web;

import com.example.battleships.model.view.ShipViewModel;
import com.example.battleships.sec.CurrentUser;
import com.example.battleships.service.ShipService;
import com.example.battleships.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Controller
public class HomeController {

    private final CurrentUser currentUser;
    private final ShipService shipService;
    private final UserService userService;

    public HomeController(CurrentUser currentUser, ShipService shipService, UserService userService) {
        this.currentUser = currentUser;
        this.shipService = shipService;
        this.userService = userService;
    }

    @GetMapping()
    public String index(Model model){

        if (currentUser.getId() != null){

            // Logged user ships!
            List<ShipViewModel> loggedUserShips = shipService.findShipsByUserID();

            // Defender Ships
            List<ShipViewModel> defenderShips = shipService.findAllShips()
                    .stream()
                    .filter(ship -> !Objects.equals(ship.getUser().getId(), currentUser.getId()))
                    .collect(Collectors.toList());

            //All Ships in DB
            List<ShipViewModel> allShips = shipService.findAllShips();

            model
                    .addAttribute("loggedUserShips",loggedUserShips)
                    .addAttribute("defenderShips",defenderShips)
                    .addAttribute("allShips",allShips);


            return "home";
        }



        return "index";
    }
}
