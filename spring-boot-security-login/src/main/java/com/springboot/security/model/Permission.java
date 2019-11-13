package com.springboot.security.model;

import lombok.Data;

import javax.persistence.*;

/**
 * @Author: 向往
 * @Contact: 2457081614@qq.com
 * @Date: 2019/11/13 0013 21:41
 * @Version: 1.0
 * @Description:
 */
@Data
@Entity
@Table(name = "t_permission")
public class Permission {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String url;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }


}
