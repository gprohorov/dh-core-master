package io.clinicway.dh.connector.terra.entity;

import lombok.EqualsAndHashCode;
import lombok.Setter;

import javax.persistence.MappedSuperclass;
import java.io.Serializable;

@MappedSuperclass
@Setter
@EqualsAndHashCode
public abstract class AbstractEntity implements Serializable {
}
