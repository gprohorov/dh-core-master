package io.clinicway.dh.connector.terra.datasource.observer.entity;

import io.clinicway.dh.connector.terra.entity.AbstractEntity;
import lombok.*;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

@Getter
@Setter
@Entity(name = "Settings")
@Table(name = "settings")
public class Settings extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private int id;

    private Timestamp create_date;
    private Date event_date;
    private Time event_time;
    @Column(nullable = false)
    private int event_type_id;
    @Column(nullable = false)
    private int is_enabled;
    private Timestamp event_datetime;
}


