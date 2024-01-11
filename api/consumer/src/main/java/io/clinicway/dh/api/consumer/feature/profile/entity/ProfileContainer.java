package io.clinicway.dh.api.consumer.feature.profile.entity;

import io.clinicway.dh.api.consumer.entity.AbstractEntity;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString(onlyExplicitlyIncluded = true)
@Entity(name = "Profile")
public class ProfileContainer extends AbstractEntity {
    @ToString.Include
    @Id
    @Column(name = "ID", nullable = false)
    private String id;

    @ToString.Include
    @Column(name = "last_name")
    private String last_name;

    @ToString.Include
    @Column(name = "first_name")
    private String first_name;

    @Column(name = "patronymic_name")
    private String patronymic_name;

    @Column(name = "date_of_birth")
    private Timestamp date_of_birth;

    @Column(name = "gender")
    private Integer gender;

    @Column(name = "email")
    private String email;

    @ToString.Include
    @Column(name = "phone")
    private String phone;
}
