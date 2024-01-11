package io.clinicway.dh.connector.terra.feature.order.dto;

import io.clinicway.dh.connector.terra.datasource.terra.entity.OrderContainer;
import io.clinicway.dh.connector.terra.dto.AbstractDto;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

/**
 * A DTO for the {@link OrderContainer} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("Order")
public class OrderDto extends AbstractDto {
    private String id;
    private String num;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp dateTimeOrder;
    private Float amountBase;
    private Float amount;
    private String surName;
    private String name;
    private String secName;
    private String sex;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp birthDate;
    private String phone;
    private String cellPhone;
    private String email;
    private String doctorSurname;
    private String doctorName;
    private String doctorSecName;
    private String doctorCode;
    private String doctorOrgCode;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp paymentDateTime;
    public String branchName;
    public String branchCity;
    public String branchAddress;
    private Integer fileCount;
}