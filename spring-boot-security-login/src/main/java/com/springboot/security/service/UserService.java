package com.springboot.security.service;

import com.springboot.security.model.Role;
import com.springboot.security.model.User;
import com.springboot.security.model.UserRole;
import com.springboot.security.repository.RoleRepository;
import com.springboot.security.repository.UserRepository;
import com.springboot.security.repository.UserRoleRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: 向往
 * @Contact: 2457081614@qq.com
 * @Date: 2019/11/11 0011 21:46
 * @Version: 1.0
 * @Description:
 */
/*@Service
@Slf4j*/

public class UserService implements UserDetailsService {

    static Logger log = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserRoleRepository userRoleRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        log.info("登录用户{}", userName);
        User user = userRepository.findByUserName(userName);
        if (user == null) {
            throw new UsernameNotFoundException("用户名不存在");
        }
        log.info("userName===>{}", user.getUsername());
        log.info("userPass===>{}", user.getPassword());
        //获取权限集合
        List<UserRole> userRoles = userRoleRepository.findUserRolesByUserId(user.getId());
        if (!CollectionUtils.isEmpty(userRoles)) {
            List<Role> roles = roleRepository.findRolesByIdIn(userRoles.stream().map(UserRole::getRoleId).collect(Collectors.toList()));
            user.setRoleList(roles);
        }
        return user;
    }
}
