package io.clinicway.dh.api.consumer.feature.order.entity;

import io.clinicway.dh.api.consumer.entity.AbstractEntity;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString(onlyExplicitlyIncluded = true)
public class OrdersContainer extends AbstractEntity {
    @Id
    public Integer page;

    public Integer pagesCount;
    public List<OrderContainer> orders;

//    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
//    public List<ServiceContainer> ServiceList;
}
