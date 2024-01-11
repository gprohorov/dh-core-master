package io.clinicway.dh.connector.terra.datasource.terra.repository;

import io.clinicway.dh.connector.terra.datasource.terra.entity.ServiceContainer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServiceContainerRepository extends JpaRepository<ServiceContainer, String> {
    @Query(
            value = "SELECT\n" +
                    "        JOR_CHECKS_DT.ID as id,\n" +
                    "        DIC_GOODS.CODE as testCode,\n" +
                    "        DIC_GOODS.NAME as testName,\n" +
                    "        JOR_CHECKS_DT.CNT as testCount,\n" +
                    "        JOR_CHECKS_DT.SUM_BASE as testPrice,\n" +
                    "        JOR_CHECKS_DT.SUM_ as testPriceWithDiscount,\n" +
                    "        JOR_CHECKS_DT.GOODS_GRP_ID as groupId, \n" +
                    "        JOR_CHECKS_DT.GOODS_GRP_NAME as groupName,\n" +
                    "        JOR_CHECKS_DT.IS_COMPLEX as isComplex, \n" +
                    "        JOR_CHECKS_DT.COMPLEX_ID as complexId,\n" +
                    "        JOR_CHECKS_DT.BLANK_ID as blankId,\n" +
                    "        bb.NAME as blankName,\n" +
                    "        JOR_CHECKS_DT.IS_REFUSE as isRefuse,\n" +
                    "        JOR_CHECKS_DT.DATE_DONE as dateDone\n" +
                    " FROM JOR_CHECKS_DT\n" +
                    "    JOIN DIC_GOODS ON DIC_GOODS.ID = JOR_CHECKS_DT.GOODS_ID\n" +
                    "    LEFT JOIN jor_blanks b ON b.blank_id = JOR_CHECKS_DT.BLANK_ID \n" +
                    "        AND b.JOR_CHECK_ID = JOR_CHECKS_DT.HD_ID\n" +
                    "    LEFT JOIN dic_blanks bb ON bb.id = b.blank_id\n" +
                    " WHERE JOR_CHECKS_DT.HD_ID = ?1\n" +
                    "    AND JOR_CHECKS_DT.is_refuse = 0\n" +
                    " ORDER BY testName ASC",
            nativeQuery = true
    )
    List<ServiceContainer> getOrderServices(String orderId);
}
