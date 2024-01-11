package io.clinicway.dh.connector.terra.feature.order.controller;

import io.clinicway.dh.connector.terra.feature.order.dto.OrderDto;
import io.clinicway.dh.connector.terra.feature.order.dto.OrdersDto;
import io.clinicway.dh.connector.terra.feature.order.dto.ServiceDto;
import io.clinicway.dh.connector.terra.feature.order.service.OrderService;
import io.clinicway.dh.connector.terra.feature.order.service.ServiceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(name = "Order", path = "/api", produces = "application/json")
@CrossOrigin(origins = "*")
@Api("Order")
@ApiOperation(value = "Orders API", notes = "Orders API", nickname = "Order")
public class OrderController {
    @Autowired
    OrderService orderService;
    @Autowired
    ServiceService serviceService;

    @GetMapping(value = "/orders")
    public ResponseEntity<OrdersDto> getOrdersForPerson(
            @RequestParam(value = "personId")
            @ApiParam(name = "personId", value = "Person ID", example = "829208c92fd94a29a3f1bd030cecb59f", required = true)
            String personId,
            @RequestParam(value = "page")
            @ApiParam(name = "page", value = "Page", example = "1", required = false, defaultValue = "1")
            Integer page
    ) {
        int perPage = 10;
        int offset = perPage * (page - 1);
        float ordersCount = orderService.countByPerson(personId);
        List<OrderDto> orders = orderService.getListByPerson(personId, perPage, offset);

        OrdersDto ordersDto = new OrdersDto();
        ordersDto.orders = orders;
        ordersDto.page = page;
        ordersDto.pagesCount = (int) Math.ceil(ordersCount/10);

        return ResponseEntity.ok(ordersDto);
    }

    @GetMapping(value = "/order/{orderId}/services")
    public ResponseEntity<List<ServiceDto>> getOrderServices(
            @PathVariable(value = "orderId")
//            @ApiParam(name = "orderId", value = "Order ID", example = "f691e1f2f7ad4388adbea57ba9ff7ed6", required = true)
            String orderId
    ) {
        return ResponseEntity.ok(serviceService.getListByOrder(orderId));
    }

    @GetMapping("/order/{id}")
    public ResponseEntity<Object> getOrder(
            @PathVariable(value = "id")
            @ApiParam(name = "orderId", value = "Order ID", example = "f691e1f2f7ad4388adbea57ba9ff7ed6", required = true)
            String orderId
    ) {
        return ResponseEntity.ok(orderService.getOne(orderId));
    }
}
