package com.meitu.mini1.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Parameter implements Serializable {

    /**
     * 主键
     */
    private Integer paraId;

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
