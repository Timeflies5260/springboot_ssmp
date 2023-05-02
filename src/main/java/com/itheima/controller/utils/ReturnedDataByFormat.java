package com.itheima.controller.utils;
import lombok.Data;

//设计表现层返回结果的模型类，用于后端与前端进行数据格式统一，也称为前后端数据协议,类名自己定义
@Data
public class ReturnedDataByFormat<T>{
    private Boolean flag;

    //换回对象可能是List，也可能是List，所以用泛型，也可以用object对象
    private T data;
    private String msg;

    public ReturnedDataByFormat(){}

    public ReturnedDataByFormat(Boolean flag){
        this.flag = flag;
    }

    public ReturnedDataByFormat(Boolean flag, T data){
        this.flag = flag;
        this.data = data;
    }

    public ReturnedDataByFormat(Boolean flag, String msg){
        this.flag = flag;
        this.msg = msg;
    }

    public ReturnedDataByFormat(String msg){
        this.flag = false;
        this.msg = msg;
    }
}
