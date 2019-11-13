package com.springboot.security.repository;

import com.springboot.security.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepository extends JpaRepository<Role,Integer> {

   List<Role> findRolesByIdIn(List<Integer> ids);
}
