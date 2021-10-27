package com.example.coffeshop.service;

import com.example.coffeshop.model.service.OrderServiceModel;
import com.example.coffeshop.model.view.OrderViewModel;

import java.util.List;

public interface OrderService {
    void addOrder(OrderServiceModel orderServiceModel);

    List<OrderViewModel> findAllOrderOrderByPriceDesc();

    void readyOrder(Long id);
}
