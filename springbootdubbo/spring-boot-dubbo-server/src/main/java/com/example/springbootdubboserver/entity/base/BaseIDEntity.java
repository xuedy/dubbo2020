package com.example.springbootdubboserver.entity.base;

import com.alibaba.fastjson.annotation.JSONField;
import com.example.springbootdubboserver.enums.Status;
import com.example.springbootdubboserver.utils.AesCBCUtil;


import javax.persistence.*;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Date;


@MappedSuperclass
public abstract class BaseIDEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JSONField(serialize=false)
    protected Long id;
    
    /**
     * 对外序列号
     */
    protected String seqNo;

    /**
     * 数据状态
     */
    @Enumerated(EnumType.STRING)
    protected Status status;
    
    /**
     * 创建时间
     */
    @Temporal(TemporalType.TIMESTAMP)
    protected Date createDate;
    /**
     * 修改时间
     */
    @Temporal(TemporalType.TIMESTAMP)
    protected Date updateDate;
    
    /**
     * 空构造
     */
    public BaseIDEntity() {
    }

    /**
     * @param id
     */
    public BaseIDEntity(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
	public String getSeqNo(){
		if(this.id!=null) {
			try {
				this.seqNo=URLEncoder.encode(AesCBCUtil.Encrypt(String.valueOf(this.id)), "UTF-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		return this.seqNo;
	}

	public void setSeqNo(String seqNo) {
		this.seqNo = seqNo;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Date getCreateDate() {
		
		if(createDate==null)
		{
			createDate=new Date();
		}
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		if(createDate==null)
		{
			createDate=new Date();
		}
		this.createDate = createDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		if(updateDate==null) {
			updateDate=new Date();
		}
		this.updateDate = updateDate;
	}

}
