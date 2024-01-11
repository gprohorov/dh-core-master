package io.clinicway.dh.connector.terra.datasource.terra.repository;

import io.clinicway.dh.connector.terra.datasource.terra.entity.OrderContainer;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderContainerRepository extends JpaRepository<OrderContainer, String> {
    @Query(
            value = "SELECT" +
                    "    first ?2" +
                    "    skip ?3" +
                    "    JOR_CHECKS.ID as id," +
                    "    JOR_CHECKS.NUM as num," +
                    "    JOR_CHECKS.DATE_TIME as dateTimeOrder," +
                    "    JOR_CHECKS.SUM_BASE as amountBase," +
                    "    JOR_CHECKS.SUM_ as amount," +
                    "    DIC_CLIENTS.SURNAME as surName," +
                    "    DIC_CLIENTS.NAME as name," +
                    "    DIC_CLIENTS.SECNAME as secName," +
                    "    CASE WHEN DIC_CLIENTS.SEX = 0 THEN 'Чоловіча' ELSE 'Жіноча' END as sex," +
                    "    DIC_CLIENTS.BIRTH_DATE as birthDate," +
                    "    DIC_CLIENTS.PHONE as phone," +
                    "    DIC_CLIENTS.CELLPHONE as cellPhone," +
                    "    DIC_CLIENTS.EMAIL as email," +
                    "    DOCTOR.SURNAME as doctorSurName," +
                    "    DOCTOR.NAME as doctorName," +
                    "    DOCTOR.SECNAME as doctorSecName," +
                    "    DOCTOR.LOGIN as doctorCode," +
                    "    ORG.CODE_NAME as doctorOrgCode," +
                    "    CASH.DATE_TIME as paymentDateTime," +
                    "    DIC_SUBDIVISIONS.NAME as branchName," +
                    "    DIC_DICS.VAL as branchCity," +
                    "    DIC_SUBDIVISIONS.ADDRESS as branchAddress," +
                    "    (select count(f.id)" +
                    "     from dic_files f" +
                    "     where f.type_dic = 'JOR_CHECKS_DIC_BLANK_ID'" +
                    "        and f.object_id like substring(JOR_CHECKS.ID from 1 for 15)||'~%') as fileCount" +
                    " FROM JOR_CHECKS" +
                    " JOIN DIC_CLIENTS ON JOR_CHECKS.CLIENT_ID = DIC_CLIENTS.ID" +
                    " LEFT JOIN DIC_CLIENTS as DOCTOR ON JOR_CHECKS.AGENT_ID = DOCTOR.ID" +
                    " LEFT JOIN DIC_ORG as ORG ON DOCTOR.ORG_ID = ORG.ID" +
                    " LEFT JOIN (SELECT * FROM JOR_CASH WHERE CASH_PAY_TYPE_ID IS NOT NULL AND IS_FISCAL = 1) as CASH ON CASH.CHECK_ID = JOR_CHECKS.ID" +
                    " LEFT JOIN DIC_SUBDIVISIONS ON JOR_CHECKS.SUBDIVISION_ID = DIC_SUBDIVISIONS.ID" +
                    " LEFT JOIN DIC_DICS ON DIC_SUBDIVISIONS.CITY_ID = DIC_DICS.ID" +
                    " WHERE DIC_CLIENTS.ID = ?1" +
                    " ORDER BY dateTimeOrder DESC",
            nativeQuery = true
    )
    List<OrderContainer> findOrdersByPerson(String personId, int perPage, int offset);

    @Query(
            value = "SELECT" +
                    "    JOR_CHECKS.ID as id," +
                    "    JOR_CHECKS.NUM as num," +
                    "    JOR_CHECKS.DATE_TIME as dateTimeOrder," +
                    "    JOR_CHECKS.SUM_BASE as amountBase," +
                    "    JOR_CHECKS.SUM_ as amount," +
                    "    DIC_CLIENTS.SURNAME as surName," +
                    "    DIC_CLIENTS.NAME as name," +
                    "    DIC_CLIENTS.SECNAME as secName," +
                    "    CASE WHEN DIC_CLIENTS.SEX = 0 THEN 'Чоловіча' ELSE 'Жіноча' END as sex," +
                    "    DIC_CLIENTS.BIRTH_DATE as birthDate," +
                    "    DIC_CLIENTS.PHONE as phone," +
                    "    DIC_CLIENTS.CELLPHONE as cellPhone," +
                    "    DIC_CLIENTS.EMAIL as email," +
                    "    DOCTOR.SURNAME as doctorSurName," +
                    "    DOCTOR.NAME as doctorName," +
                    "    DOCTOR.SECNAME as doctorSecName," +
                    "    DOCTOR.LOGIN as doctorCode," +
                    "    ORG.CODE_NAME as doctorOrgCode," +
                    "    CASH.DATE_TIME as paymentDateTime," +
                    "    (select count(f.id)" +
                    "     from dic_files f" +
                    "     where f.type_dic = 'JOR_CHECKS_DIC_BLANK_ID'" +
                    "        and f.object_id like substring(JOR_CHECKS.ID from 1 for 15)||'~%') as fileCount" +
                    " FROM JOR_CHECKS" +
                    " JOIN DIC_CLIENTS ON JOR_CHECKS.CLIENT_ID = DIC_CLIENTS.ID" +
                    " LEFT JOIN DIC_CLIENTS as DOCTOR ON JOR_CHECKS.AGENT_ID = DOCTOR.ID" +
                    " LEFT JOIN DIC_ORG as ORG ON DOCTOR.ORG_ID = ORG.ID" +
                    " LEFT JOIN (SELECT * FROM JOR_CASH WHERE CASH_PAY_TYPE_ID IS NOT NULL AND IS_FISCAL = 1) as CASH ON CASH.CHECK_ID = JOR_CHECKS.ID" +
                    " where JOR_CHECKS.ID = ?1",
            nativeQuery = true
    )
    @NotNull
    OrderContainer getOne(@NotNull String orderId);

    @Query(
            value = "SELECT count(JOR_CHECKS.ID) as ordersCount" +
                    " FROM JOR_CHECKS" +
                    " JOIN DIC_CLIENTS ON JOR_CHECKS.CLIENT_ID = DIC_CLIENTS.ID" +
                    " where DIC_CLIENTS.ID = ?1",
            nativeQuery = true
    )
    int countByPerson(@NotNull String personId);
}