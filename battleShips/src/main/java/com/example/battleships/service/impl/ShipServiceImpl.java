package com.example.battleships.service.impl;

import com.example.battleships.model.entity.Ship;
import com.example.battleships.model.service.ShipServiceModel;
import com.example.battleships.model.view.ShipViewModel;
import com.example.battleships.repository.ShipRepository;
import com.example.battleships.sec.CurrentUser;
import com.example.battleships.service.CategoryService;
import com.example.battleships.service.ShipService;
import com.example.battleships.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ShipServiceImpl implements ShipService {

        private final ShipRepository shipRepository;
        private final ModelMapper modelMapper;
        private final UserService userService;
        private final CategoryService categoryService;
        private final CurrentUser currentUser;

    public ShipServiceImpl(ShipRepository shipRepository, ModelMapper modelMapper, UserService userService, CategoryService categoryService, CurrentUser currentUser) {
        this.shipRepository = shipRepository;
        this.modelMapper = modelMapper;
        this.userService = userService;
        this.categoryService = categoryService;
        this.currentUser = currentUser;
    }

    @Override
    public void addShip(ShipServiceModel shipServiceModel) {

        Ship ship = modelMapper.map(shipServiceModel,Ship.class);
        ship.setUser(userService.findById(currentUser.getId()));
        ship.setCategory(categoryService.findByCategoryNameEnum(shipServiceModel.getCategory()));

        shipRepository.save(ship);
    }

    @Override
    public List<ShipViewModel> findShipsByUserID() {
        return shipRepository.findAllByUserId(currentUser.getId())
                .stream()
                .map(ship -> modelMapper.map(ship,ShipViewModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<ShipViewModel> findAllShips() {
        return shipRepository.findAll()
                .stream()
                .map(ship -> modelMapper.map(ship,ShipViewModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public void attackShips(Long attacker, Long defender) {
        Ship attacker1 = shipRepository.findById(attacker).orElse(null);
        Ship defender1 = shipRepository.findById(defender).orElse(null);
        System.out.println(attacker1.getId());
        if (defender1.getHealth() <= 0 || defender1.getHealth() - attacker1.getPower() <= 0 ){
            shipRepository.delete(defender1);
            System.out.println("first");
        }else if (defender1.getHealth() - attacker1.getPower() >= 0){
            System.out.println("second");
            defender1.setHealth(defender1.getHealth() - attacker1.getPower());
            shipRepository.save(defender1);
        }

    }
}
