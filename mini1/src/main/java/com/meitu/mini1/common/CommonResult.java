package com.meitu.mini1.common;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {

    /**
     * 返回编码
     */
    private  Integer code;

    /**
     * 消息
     */
    private  String message;

    /**
     * 数据
     */
    private T   data;

    public CommonResult(Integer code, String message) {
       this(code,message,null);
    }
}
