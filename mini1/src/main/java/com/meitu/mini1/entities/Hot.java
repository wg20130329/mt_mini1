package com.meitu.mini1.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Hot implements Serializable {

    /**
     * 名称
     */
    private String  name;

    /**
     * 数量
     */
    private Double number;

    /**
     * 最后更新
     */
    private Date lastTime;

    public Hot(String  name,Double number){
        this.name = name;
        this.number = number;
    }
    }
