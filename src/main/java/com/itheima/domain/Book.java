package com.itheima.domain;
//lombok

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


//@Getter
//@Setter
//@ToString
@Data
public class Book {
    private Integer id;
    private String type;
    private String name;
    private String description;
}
