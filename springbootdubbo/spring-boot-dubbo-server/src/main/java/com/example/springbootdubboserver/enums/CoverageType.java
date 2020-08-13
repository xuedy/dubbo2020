package com.example.springbootdubboserver.enums;

/**
 * 险种类型枚举
 * @author Tommy
 * @date 2018/05/25
 */
public enum CoverageType {
    // 主险
	MAIN("true"),
	// 附加险
	SUB("false");
	
    private String desc;
    
    CoverageType(String desc) {
        this.desc = desc;
    }
    
    public String desc() {
        return this.desc;
    }
    
}
