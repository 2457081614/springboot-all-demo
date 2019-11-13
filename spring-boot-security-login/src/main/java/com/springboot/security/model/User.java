package com.springboot.security.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

/**
 * @Author: 向往
 * @Contact: 2457081614@qq.com
 * @Date: 2019/11/11 0011 21:40
 * @Version: 1.0
 * @Description:
 */
@Setter
@Getter
@ToString
@Entity
@Table(name = "t_user")
@Data
public class User implements UserDetails {
    static Logger log = LoggerFactory.getLogger(User.class);
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;
    @Column(name = "user_name")
    String userName;
    @Column(name = "user_pass")
    String userPass;

    @Transient
    private List<Role> roleList;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roleList;
    }

    public List<Role> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }

    @Override
    public String getPassword() {
        return userPass;
    }

    public Integer getId() {
        return id;
    }

    public static Logger getLog() {
        return log;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}