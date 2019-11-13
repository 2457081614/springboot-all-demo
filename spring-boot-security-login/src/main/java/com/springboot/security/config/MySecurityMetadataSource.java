package com.springboot.security.config;

import com.springboot.security.model.Permission;
import com.springboot.security.model.Role;
import com.springboot.security.model.RolePermission;
import com.springboot.security.repository.PermissionRepository;
import com.springboot.security.repository.RolePermissionRepository;
import com.springboot.security.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import javax.annotation.PostConstruct;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author: 向往
 * @Contact: 2457081614@qq.com
 * @Date: 2019/11/13 0013 22:40
 * @Version: 1.0
 * @Description:
 */


@Component
public class MySecurityMetadataSource implements FilterInvocationSecurityMetadataSource {

    //本方法返回访问资源所需的角色集合
    AntPathMatcher antPathMatcher = new AntPathMatcher();

    @Autowired
    private PermissionRepository permissionRepository;

    @Autowired
    private RolePermissionRepository rolePermissionRepository;
    @Autowired
    private RoleRepository roleRepository;

    private Map<String, List<ConfigAttribute>> rolesByUrl = new HashMap<>(64);

    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
        //从object中得到需要访问的资源，即网址
        String requestUrl = ((FilterInvocation) object).getRequestUrl();
        //从数据库中得到所有资源，以及对应的角色
        List<Permission> permissions = permissionRepository.findAll();
        for (Permission permission : permissions) {
            //首先进行地址匹配
            if (antPathMatcher.match(permission.getUrl(), requestUrl)) {
                return rolesByUrl.get(requestUrl);
            }
        }
        //匹配不成功返回一个特殊的ROLE_NONE
        return SecurityConfig.createList("ROLE_NONE");
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return FilterInvocation.class.isAssignableFrom(clazz);
    }


    @PostConstruct
    public void init() {
        List<Permission> permissions = permissionRepository.findAll();
        List<RolePermission> rolePermissions = rolePermissionRepository.findAll();
        permissions.forEach(permission ->
        {
            List<Role> roles = roleRepository.findRolesByIdIn(rolePermissions.stream().filter(t->
            t.getPermissionId().equals(permission.getId())).map(RolePermission::getRoleId).collect(Collectors.toList()));
            List<ConfigAttribute> configAttributes = new ArrayList<>();
          for(Role role:roles)
          {
              ConfigAttribute configAttribute = new SecurityConfig(role.getName());
              configAttributes.add(configAttribute);
          }
          rolesByUrl.put(permission.getUrl(),configAttributes);

        });

    }
}
