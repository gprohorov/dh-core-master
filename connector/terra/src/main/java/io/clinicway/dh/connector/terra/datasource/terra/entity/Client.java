package io.clinicway.dh.connector.terra.datasource.terra.entity;

import io.clinicway.dh.connector.terra.entity.AbstractEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

@Getter
@Setter
@ToString(onlyExplicitlyIncluded = true)
@Entity(name = "Client")
@Table(name = "DIC_CLIENTS")
public class Client extends AbstractEntity {
    @ToString.Include
    @Id
    @Column(name = "ID", nullable = false)
    private String id;

    @Column(name = "GRP_ID")
    private String grpId;

    @ToString.Include
    @Column(name = "")
    private String SURNAME;

    @ToString.Include
    @Column(name = "NAME")
    private String NAME;

    @Column(name = "SECNAME")
    private String SECNAME;

    @Column(name = "CODE_NAME", nullable = false)
    private String CODE_NAME;

    @Column(name = "SEX", nullable = false)
    private Integer SEX;

    @Column(name = "BIRTH_DATE")
    private Date BIRTH_DATE;

    @Column(name = "ADDRESS")
    private String ADDRESS;

    @Column(name = "PHONE")
    private String PHONE;

    @Column(name = "CELLPHONE")
    private String CELLPHONE;

    @Column(name = "EMAIL")
    private String EMAIL;

    @Column(name = "CARD_NUM")
    private String CARD_NUM;

    @Column(name = "DESCR")
    private String DESCR;

    @Column(name = "DESCR_PREVIEW")
    private String DESCR_PREVIEW;

    @Column(name = "IS_SEND_SMS", nullable = false)
    private Integer IS_SEND_SMS;

    @Column(name = "IS_SEND_EMAIL", nullable = false)
    private Integer IS_SEND_EMAIL;

    @Column(name = "IS_SEND_WEB", nullable = false)
    private Integer IS_SEND_WEB;

    @Column(name = "LOGIN")
    private String LOGIN;

    @Column(name = "PASS")
    private String PASS;

    @Column(name = "ORG_ID")
    private String ORG_ID;

    @Column(name = "TYPE_PRICE_ID")
    private String TYPE_PRICE_ID;

    @Column(name = "TYPE_BONUSES_ID")
    private String TYPE_BONUSES_ID;

    @Column(name = "BONUS_PRC", nullable = false)
    private Float BONUS_PRC;

    @Column(name = "TYPE_CLIENT_ID")
    private String TYPE_CLIENT_ID;

    @Column(name = "ACC_SUM_ADD", nullable = false)
    private Float ACC_SUM_ADD;

    @Column(name = "SYTE_SYNC_NEEDED", nullable = false)
    private Integer SYTE_SYNC_NEEDED;

    @Column(name = "DEPARTMENT_ID")
    private String DEPARTMENT_ID;

    @Column(name = "JOB_TITLE_ID")
    private String JOB_TITLE_ID;

    @Column(name = "MANAGER_ID")
    private String MANAGER_ID;

    @Column(name = "MANAGER_PRC")
    private Float MANAGER_PRC;

    @Column(name = "ADD_SUBDIVISION_ID")
    private String ADD_SUBDIVISION_ID;

    @Column(name = "CODEPHONE")
    private String CODEPHONE;

    @Column(name = "AGENT_GRP_ID")
    private String AGENT_GRP_ID;

    @Column(name = "REGION_ID")
    private String REGION_ID;

    @Column(name = "AREA_ID")
    private String AREA_ID;

    @Column(name = "CITY_ID")
    private String CITY_ID;

    @Column(name = "GIS_CODE_CLIENT")
    private String GIS_CODE_CLIENT;

    @Column(name = "GIS_CODE_AGENT")
    private String GIS_CODE_AGENT;
}
