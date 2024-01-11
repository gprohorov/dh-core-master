package io.clinicway.dh.api.consumer.feature.order.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.clinicway.dh.api.consumer.dto.AbstractDto;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("Order")
public class OrderDto extends AbstractDto {
    public String id;
    public String num;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    public Timestamp dateTimeOrder;
    public Float amountBase;
    public Float amount;
    public String name;
    public String surName;
    public String secName;
    public String sex;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    public Timestamp birthDate;
    public String phone;
    public String cellPhone;
    public String email;
    public String doctorName;
    public String doctorSurname;
    public String doctorSecName;
    public String doctorCode;
    public String doctorOrgCode;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    public Timestamp paymentDateTime;
    public String branchName;
    public String branchCity;
    public String branchAddress;
    public Integer fileCount;
}
