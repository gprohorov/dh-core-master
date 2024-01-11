package io.clinicway.dh.api.consumer.feature.person.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.clinicway.dh.api.consumer.feature.person.entity.PersonContainer;
import io.clinicway.dh.api.consumer.dto.AbstractDto;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.sql.Timestamp;

/**
 * A DTO for the {@link PersonContainer} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("Person")
public class PersonDto extends AbstractDto {
    private String id;
    private String last_name;
    private String first_name;
    private String patronymic_name;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp date_of_birth;
    private Integer gender;
    private String email;
    private String phone;
}