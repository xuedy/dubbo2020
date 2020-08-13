package com.example.springbootdubboserver.entity.config;



import com.example.springbootdubboserver.entity.base.BaseIDEntity;
import com.example.springbootdubboserver.enums.CoverageType;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "OS_CoverageConfig")
@Data
public class CoverageConfig extends BaseIDEntity {

	private static final long serialVersionUID = 5381768896678149228L;
	/**
     * 产品
     */
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "productId")
    @NotNull
	private ProductConfig product;
	
	/**
     * 险种类型 - 主险 附加险
     */
	@Enumerated(EnumType.STRING)
	private CoverageType coverageType;
	
	/**
     * 是否必须附加（打包销售）
     */
    private boolean isRequired;
	
	/**
     * 是否为产品套餐 - 如乐游
     */
	private boolean isPackage;
	
	/**
	 * 是否是有无社保
	 */
	private boolean socialSecurity;
	
	/**
     * 是否与主险同步 
     */
	
	private boolean isSyncMain;
	
	/**
     * 险种代码
     */
	private String coverageCode;
	
	/**
     * 险种互斥标记
     */
	private String coverageIdentity;
	
	/**
     * 险种名称
     */
	private String coverageName;
	
	/**
     * 计划 - 产品套餐专用
     */
    private String planNo;
	
	/**
     * 保额方式
     */
    @Column(nullable = true, columnDefinition = "varchar(355)")
	private String coverAmount;
    
    /**
     * 份数配置
     */
    @Column(nullable = true, columnDefinition = "varchar(1024) default '[]'")
	private String copiesOption;
	
	/**
     * 最大保额
     */
	private int maxCover;
	
	/**
     * 最小保额
     */
	private int minCover;
	
	
	/**
     * 保额输入方式
     */
	private String coverAmountWay;
	
	/**
     * 交费期间
     */
	@Column(nullable = true, columnDefinition = "varchar(500)")
    private String paymentTerm;
    
    /**
     * 保障期间单位
     */
    private String coverageTermType;
    
    /**
     * 保障期间
     */
    private int coverageTerm;
    
    /**
     * 短期保障期间
     */  
    @Column(nullable = true, columnDefinition = "varchar(1200)")
    private String shortCoverageTerm;
    
    /**
     * 投保年龄下限
     * 
     */
    @Column(columnDefinition="int default 1",nullable=false)
    private int issueLowerAgeLimit;
    
    /**
     * 投保年龄下限单位
     * 
     */
    private String issueLowerAgeLimitType;
    
    /**
     * 投保年龄上限
     * 
     */
    @Column(columnDefinition="int default 1",nullable=true)
    private int issueUpperAgeLimit;
    
    /**
     * 投保年龄上限单位
     * 
     */
    private String issueUpperAgeLimitType;
    
    /**
     * 最大缴费年龄上限
     * 
     */
    @Column(columnDefinition="int default 1",nullable=true)
    private int paymentTermUpperAgeLimit;
    
    /**
     * 险种页面显示名称
     */
    private String pageShowName;
    
    /**
     * 控制前台短期险控制保额的增加数量
     */   
    private int stepsCover;
    
    /**
     * 控制前台短期险附加险的保额增加比例%
     */
    private String stepsPercent;


}
