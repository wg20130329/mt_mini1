package com.meitu.mini1.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HotDto implements Serializable {

    /**
     * 名称
     */
    private String  name;

    /**
     * 数量
     */
    private int number;

    /**
     * 最后更新
     */
    private Date lastTime;


    /**
     * 操作类型 1:表示后台添加  2：表示后台修改
     */
    private String type;

    }
