package io.clinicway.dh.api.consumer.feature.order.entity;

import io.clinicway.dh.api.consumer.entity.AbstractEntity;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString(onlyExplicitlyIncluded = true)
@Entity(name = "Order")
public class OrderContainer extends AbstractEntity {
    @Id
    public String id;
    public String num;
    public String dateTimeOrder;
    public Float amountBase;
    public Float amount;
    public String name;
    public String surName;
    public String secName;
    public String sex;
    public String birthDate;
    public String phone;
    public String cellPhone;
    public String email;
    public String doctorSurname;
    public String doctorName;
    public String doctorSecName;
    public String doctorCode;
    public String doctorOrgCode;
    public String paymentDateTime;
    public String branchName;
    public String branchCity;
    public String branchAddress;
    public Integer fileCount;

//    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
//    public List<ServiceContainer> ServiceList;
}
