package com.example.battleships.service;

import com.example.battleships.model.service.ShipServiceModel;
import com.example.battleships.model.view.ShipViewModel;

import java.util.List;

public interface ShipService {
    void addShip(ShipServiceModel shipServiceModel);

    List<ShipViewModel> findShipsByUserID();

    List<ShipViewModel> findAllShips();

    void attackShips(Long attacker, Long defender);
}
