package io.clinicway.dh.connector.terra.datasource.terra.entity;

import io.clinicway.dh.connector.terra.entity.AbstractEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;

@Getter
@Setter
@ToString(onlyExplicitlyIncluded = true)
@Entity(name = "Service")
public class ServiceContainer extends AbstractEntity {
    @Id
    public String id;
    public String testCode;
    public String testName;
    public Float testCount;
    public Float testPrice;
    public Float testPriceWithDiscount;
    public String groupId;
    public String groupName;
    public Integer isComplex;
    public String complexId;
    public String blankId;
    public String blankName;
    public Integer isRefuse;
    public Timestamp dateDone;
}
