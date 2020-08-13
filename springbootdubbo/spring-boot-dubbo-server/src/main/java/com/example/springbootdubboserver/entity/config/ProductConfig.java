package com.example.springbootdubboserver.entity.config;

import com.example.springbootdubboserver.entity.base.BaseIDEntity;
import lombok.Data;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "OS_ProductConfig")
@Data
public class ProductConfig extends BaseIDEntity {

	private static final long serialVersionUID = 3295082091391227748L;
	
	/**
     * 产品名称
     */
    @NotNull
	private String productName;
    
    /**
     * 产品代码
     */
    
	private String productCode;
	
	/**
	 * 产品类型
	 */
	private String productType;
	
	/**
	 * 产品类型描述
	 */
	private String productTypeName;
	
	/**
     * 产品描述
     */
    
	private String productDesc;
	
	/**
     * 产品详细描述
     */
    
	private String productContent;
	
	/**
     * 产品责任描述
     */
	  @Column(nullable = true, columnDefinition = "varchar(1255)")
	private String productCoverage;
	
	/**
     * 产品特色（图片路径）
     */
    
	private String productImgUrl;
	
	/**
     * 产品海报（图片路径）
     */
    
	private String productBannerImgUrl;
    
	/**
     * 渠道
     */
    private String channel;
    
    /**
     * 保单打印类型
     */
    private String policyForm;    
      
    /**
     * 是否自动续保
     */
    private boolean isAutoRenew;
    
    /**
     * 是否需要上传身份证
     */
    private boolean isNeedIdentityCard;
            
	/**
     * 是否可回溯/追溯
     */
    private boolean isBack;
    
    /**
     * 是否显示有无社保选项
     */
    @Column(nullable = true)
    private boolean socialSecurityShow;
    
    /**
     * 是否限制信用卡支付
     */
    @Column(nullable = true)
    private boolean limitPay;

    /**
     * beneficiary type
     */
    private String beneficiaryType;

    /**
     * 交费周期
     */
    private String paymentFrequency;
    
    /**
     * 生存金领取方式
     */
    private String couponType;
    
    /**
     * 分红领取方式 
     */
    private String divType;
    
    /**
     * 产品特色图片路径
     */
    private String imgUrl;
    
    /**
     * 相关文档信息
     * 
     */
    @Column(nullable = true, columnDefinition = "varchar(1000)")
    private String docs;	
    
    /**
     * 产品缩略图
     */
    private String thumbnailUrl;
    
    /**
     * 吸引价格
     */
    private String  basePrice;
    
    /**
     * 产品标签
     */
    private String productLabel;
    
    /**
     * 长期/短期险
     */
    private String longOrShortTerm;
     
    /**
     * 健康类型
     */
    private String healthType;
    /**
     * 可为谁投保
     */
    private String forWhoInsureds;
    
    /**
     * 健康告知问题
     */
	 @OneToMany(mappedBy = "productConfig", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	 @OrderBy(value = "id ASC")
	 private List<HealthQuestionsConfig> notificationQuestions;

	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<CoverageConfig> coverageConfigs;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "productTypeConfigId")
	private ProductTypeConfig productTypeConfig;
     
}
