package io.clinicway.dh.connector.terra.datasource.terra.repository;

import io.clinicway.dh.connector.terra.datasource.terra.entity.PersonContainer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonContainerRepository extends JpaRepository<PersonContainer, String> {
    @Query(
            value = "SELECT c.id," +
                    "    c.SURNAME AS last_name," +
                    "    c.NAME AS first_name," +
                    "    c.SECNAME AS patronymic_name," +
                    "    c.BIRTH_DATE AS date_of_birth," +
                    "    c.sex AS gender," +
                    "    c.EMAIL AS email," +
                    "    CASE WHEN (c.PHONE IS NOT NULL AND c.PHONE <> '') then c.CELLPHONE || ', ' || c.PHONE ELSE c.CELLPHONE END AS phone" +
                    "    FROM DIC_CLIENTS c" +
                    "    WHERE c.CELLPHONE LIKE %?1% OR c.PHONE LIKE %?1%",
            nativeQuery = true
    )
    PersonContainer findOneByPhone(String phone);
}

