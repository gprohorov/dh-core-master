package io.clinicway.dh.connector.terra.feature.order.dto;

import io.clinicway.dh.connector.terra.dto.AbstractDto;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("Orders")
public class OrdersDto extends AbstractDto {
    public List<OrderDto> orders;

    public Integer page;

    public Integer pagesCount;
}
