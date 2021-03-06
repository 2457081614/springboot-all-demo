package com.springboot.security.model;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

/**
 * @Author: 向往
 * @Contact: 2457081614@qq.com
 * @Date: 2019/11/11 0011 21:42
 * @Version: 1.0
 * @Description:
 */
@Data
@ToString
@Entity
@Table(name = "t_user_role_ref")
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private Integer userId;

    private Integer roleId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }
}