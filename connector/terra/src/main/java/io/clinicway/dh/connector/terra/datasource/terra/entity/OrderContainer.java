package io.clinicway.dh.connector.terra.datasource.terra.entity;

import io.clinicway.dh.connector.terra.entity.AbstractEntity;
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
    public Timestamp dateTimeOrder;
    public Float amountBase;
    public Float amount;
    public String surName;
    public String name;
    public String secName;
    public String sex;
    public Timestamp birthDate;
    public String phone;
    public String cellPhone;
    public String email;
    public String doctorSurname;
    public String doctorName;
    public String doctorSecName;
    public String doctorCode;
    public String doctorOrgCode;
    public Timestamp paymentDateTime;
    public String branchName;
    public String branchCity;
    public String branchAddress;
    public Integer fileCount;

//    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
//    public List<ServiceContainer> ServiceList;
}
