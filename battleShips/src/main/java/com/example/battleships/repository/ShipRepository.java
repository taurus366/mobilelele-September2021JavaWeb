package com.example.battleships.repository;

import com.example.battleships.model.entity.Ship;
import com.example.battleships.model.view.ShipViewModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShipRepository extends JpaRepository<Ship,Long> {
    List<Ship> findAllByUserId(Long user_id);
}
