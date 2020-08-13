package com.example.springbootdubboserver.entity.config;



import com.example.springbootdubboserver.entity.base.BaseIDEntity;
import lombok.Data;

import javax.persistence.*;

/**
 * 健康告知问题
 * @author qsnp236
 *
 */
@Entity
@Data
@Table(name = "OS_HealthQuestionsConfig")
public class HealthQuestionsConfig extends BaseIDEntity {
	
	private static final long serialVersionUID = 5381768896678149228L;
	/**
     * 产品
     */
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "productId")
	private ProductConfig productConfig;
	
	 /**
     * 健康告知问题编号
     */
	 private String no;
	 /**
     * 健康告知问题名称
     */
	 @Column(nullable = true, columnDefinition = "varchar(1200)")
	 private String name;
	 /**
     * 健康告知问题编码
     */
	 private String code;
	 /**
     * 健康告知问题类型
     * input ,select,check
     */
	 private String type;
	 
	 /**
     * 健康告知问题是否必填
     */
	 private Boolean must;
	 
	 /**
     * 健康告知问题是否显示图标
     */
	 
	 private Boolean showIcon;
	 
	 /**
     * 健康告知问题为select时候是否有输入项
     */
	 private Boolean hasItem;
	 
	 /**
     * 健康告知问题类型为select时候输入项
     */
	 @Column(nullable = true, columnDefinition = "varchar(1600)")
	 private String item;

	 /**
     * 健康告知问题内容
     */
	 @Column(nullable = true, columnDefinition = "varchar(1000)")
	 private String content;
	 
	 /**
     * 健康告inout输入类型校验正则表达式
     */
	 private String regExp;
	 /**
     * 健康告下拉选择答案
     */
	 private String selectAnswer;
	 /**
	  * 输入框允许最大长度
	  * @return
	  */
	
	 private int maxLength;


}
