package io.clinicway.dh.api.consumer.feature.order.controller;

import io.clinicway.dh.api.consumer.exception.ClientNotFoundException;
import io.clinicway.dh.api.consumer.feature.order.dto.OrderDto;
import io.clinicway.dh.api.consumer.feature.order.service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(name = "Order", path = "/api/order", produces = "application/json")
@CrossOrigin(origins = "*")
@Api("Orders")
@ApiOperation(value = "Order API", notes = "Order API", nickname = "Order")
public class OrderController {
    Logger logger = LoggerFactory.getLogger(OrdersController.class);

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Object> findOne(@PathVariable String id) throws ClientNotFoundException {
        Optional<OrderDto> order = orderService.getById(id);

        return order.<ResponseEntity<Object>>map(ResponseEntity::ok).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

}
