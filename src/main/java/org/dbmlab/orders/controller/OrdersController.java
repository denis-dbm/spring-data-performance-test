package org.dbmlab.orders.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.dbmlab.orders.apimodel.OrderAutomatedCreationModel;
import org.dbmlab.orders.model.Order;
import org.dbmlab.orders.model.OrderItem;
import org.dbmlab.orders.model.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/orders")
public class OrdersController {

    @Autowired
    private OrderRepository orderRepository;

    @RequestMapping(method = RequestMethod.POST, path = "/$_automation/create")
    public void automatedCreation(@RequestBody(required = true) @Validated OrderAutomatedCreationModel model) {
        
        for (int i = 0; i < model.getOrdersCount(); i++) {
            Order newOrder = new Order();

            newOrder.setCreatedAt(new Date());
            newOrder.setCustomerName(model.getCustomerName());

            Double totalAmount = 0D;
            List<OrderItem> newItems = new ArrayList<>();

            for (int j = 0; j < model.getItemsPerOrderCount(); j++) {
                OrderItem item = new OrderItem();

                item.setNotes(model.getDefaultItemsNotes());
                item.setOrder(newOrder);
                item.setPrice(1D);
                item.setProductCode("PRD-" + j);
                item.setQuantity(1D);
                item.setTotalAmount(1D);
                newItems.add(item);

                totalAmount += 1D;
            }

            newOrder.setItems(newItems);
            newOrder.setTotalAmount(totalAmount);

            orderRepository.save((newOrder));
        }
    }
}