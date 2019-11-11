package com.springboot.security.service;

import com.springboot.security.model.User;
import com.springboot.security.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * @Author: 向往
 * @Contact: 2457081614@qq.com
 * @Date: 2019/11/11 0011 21:46
 * @Version: 1.0
 * @Description:
 */
/*@Service
@Slf4j*/
public class UserService  implements UserDetailsService {

    static Logger log = LoggerFactory.getLogger(UserService.class);

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        log.info("param--userName===>" + userName);
        User user = userRepository.findByUserName(userName);
        if(user == null){
            log.info("user===>" + user);
            throw new UsernameNotFoundException("用户名不存在");
        }
        log.info("userName===>" + user.getUsername());
        log.info("userPass===>" + user.getPassword());
        return user;
    }
}
