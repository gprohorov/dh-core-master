package io.clinicway.dh.connector.terra.feature.order.dto;

import io.clinicway.dh.connector.terra.datasource.terra.entity.ServiceContainer;
import io.clinicway.dh.connector.terra.dto.AbstractDto;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

/**
 * A DTO for the {@link ServiceContainer} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("Service")
public class ServiceDto extends AbstractDto {
    private String id;
    private String testCode;
    private String testName;
    private Float testCount;
    private Float testPrice;
    private Float testPriceWithDiscount;
    private String groupId;
    private String groupName;
    private Integer isComplex;
    private String complexId;
    private String blankId;
    private String blankName;
    private Integer isRefuse;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp dateDone;
}
