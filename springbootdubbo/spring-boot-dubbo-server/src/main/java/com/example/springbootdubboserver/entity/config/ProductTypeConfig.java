package com.example.springbootdubboserver.entity.config;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.alibaba.fastjson.annotation.JSONField;
import com.example.springbootdubboserver.entity.base.BaseIDEntity;
import lombok.Data;


@Entity
@Table(name = "OS_ProductTypeConfig")
@Data
public class ProductTypeConfig extends BaseIDEntity {
    
	private static final long serialVersionUID = -7081577572212403139L;
	
	/**
	 * 产品类型
	 */
	private String value;
	
	/**
	 * 产品类型描述(名称)
	 */
	private String label;
	
	/**
	 * 类型图标展示
	 */
	private String url;
	
	/**
	 * 渠道信息
	 */
	private String channel;
	
	/**
	 * 渠道名称
	 */
	private String channelName;
	
	@JSONField(serialize=false)
	@OneToMany(mappedBy = "productTypeConfig", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ProductConfig> productConfigs;

	
}
