package io.clinicway.dh.connector.terra.datasource.terra.repository;

import io.clinicway.dh.connector.terra.datasource.terra.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, String> {
    @Query(
            value = "SELECT c.id," +
                    "    c.SURNAME AS last_name," +
                    "    c.NAME AS first_name," +
                    "    c.SECNAME AS patronymic_name," +
                    "    c.BIRTH_DATE AS date_of_birth," +
                    "    c.sex AS gender," +
                    "    c.EMAIL," +
                    "    CASE WHEN (c.PHONE IS NOT NULL AND c.PHONE <> '') then c.CELLPHONE || ', ' || c.PHONE ELSE c.CELLPHONE END AS phone" +
                    "    FROM DIC_CLIENTS c" +
                    "    WHERE c.CELLPHONE LIKE '%:Phone%' OR c.PHONE LIKE '%:Phone%' LIMIT 1",
            nativeQuery = true
    )
    Client findOneByPhone(@Param("Phone") String phone);
}