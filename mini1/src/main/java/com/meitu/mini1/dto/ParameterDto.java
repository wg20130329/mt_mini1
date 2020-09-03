package com.meitu.mini1.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ParameterDto {

    /**
     * 主键
     */
    private String paraId;

    /**
     * 描述
     */
    private String  paraName;

    /**
     * 参数值
     */
    private String  paraValue;

    /**
     * 类型
     */
    private  String paraType;
}
