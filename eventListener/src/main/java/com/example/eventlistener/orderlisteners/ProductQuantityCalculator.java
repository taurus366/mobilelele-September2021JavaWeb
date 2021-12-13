package com.example.eventlistener.orderlisteners;

import com.example.eventlistener.ApplicationListenerTest;
import com.example.eventlistener.OrderCreatedEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class ProductQuantityCalculator {

    private Logger logger = LoggerFactory.getLogger(ApplicationListenerTest.class);

    @EventListener(OrderCreatedEvent.class)
    public void onOrderCreated(OrderCreatedEvent orderCreatedEvent) {

        logger.info("Order no {} has been created. I'm going to calculate the current product quantities.",orderCreatedEvent.getOrderId());
    }
    // TODO - see what products had been ordered and calculate subtract product quantities.

}
