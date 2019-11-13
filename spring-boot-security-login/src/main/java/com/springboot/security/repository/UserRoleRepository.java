package com.springboot.security.repository;

import com.springboot.security.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Author: 向往
 * @Contact: 2457081614@qq.com
 * @Date: 2019/11/13 0013 21:49
 * @Version: 1.0
 * @Description:
 */
public interface UserRoleRepository extends JpaRepository<UserRole,Integer> {
    UserRole findUserRoleByUserId(Integer userId);

    List<UserRole> findUserRolesByUserId(Integer userId);
}
