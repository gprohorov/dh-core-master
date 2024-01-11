package io.clinicway.dh.api.consumer.feature.order.dto;

import io.clinicway.dh.api.consumer.dto.AbstractDto;
import io.clinicway.dh.api.consumer.feature.order.entity.OrderContainer;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("Orders")
public class OrdersDto extends AbstractDto {
    public String id;
    public String page;

    public List<OrderContainer> orders;
}
