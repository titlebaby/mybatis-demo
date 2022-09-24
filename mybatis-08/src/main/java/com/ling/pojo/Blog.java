package com.ling.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class Blog {
    private String id;
    private String title;
    private String author;
    private Date createTime; //和数据库不一致
    private int views;


}
