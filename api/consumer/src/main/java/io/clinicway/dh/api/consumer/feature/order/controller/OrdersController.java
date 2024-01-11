package io.clinicway.dh.api.consumer.feature.order.controller;

import io.clinicway.dh.api.consumer.exception.ClientNotFoundException;
import io.clinicway.dh.api.consumer.feature.order.dto.OrderDto;
import io.clinicway.dh.api.consumer.feature.order.dto.OrdersDto;
import io.clinicway.dh.api.consumer.feature.order.service.OrderService;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(name = "Orders", path = "/api/orders", produces = "application/json")
@CrossOrigin(origins = "*")
@Api("Orders")
@ApiOperation(value = "Orders API", notes = "Orders API", nickname = "Orders")
public class OrdersController {
    Logger logger = LoggerFactory.getLogger(OrdersController.class);

    private final OrderService orderService;

    public OrdersController(OrderService orderService) {
        this.orderService = orderService;
    }

    @ApiOperation(value = "Get an orders list by person ID", notes = "Returns a List of Order entity")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved"),
            @ApiResponse(code = 404, message = "Not found - The person was not found")
    })
    @GetMapping()
    public ResponseEntity<Object> getOrdersByPersonId(
            @RequestParam(value = "personId")
            @ApiParam(name = "personId", value = "Person ID", example = "f691e1f2f7ad4388adbea57ba9ff7ed6", required = true)
            String personId,
            @RequestParam(value = "page")
            @ApiParam(name = "page", value = "Page", example = "1", required = false, defaultValue = "1")
            Integer page
    ) throws ClientNotFoundException {
        Optional<OrdersDto> orders = orderService.getByPersonId(personId, page);

        return orders.<ResponseEntity<Object>>map(ResponseEntity::ok).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
