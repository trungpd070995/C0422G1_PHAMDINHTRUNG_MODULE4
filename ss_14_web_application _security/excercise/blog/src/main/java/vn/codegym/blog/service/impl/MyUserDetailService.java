package vn.codegym.blog.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vn.codegym.blog.model.MyUserDetail;
import vn.codegym.blog.model.User;
import vn.codegym.blog.service.IUserService;

@Service
@Transactional
public class MyUserDetailService implements UserDetailsService {
    @Autowired
    private IUserService iUserService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = iUserService.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException(username + "not found!");
        }

        return new MyUserDetail(user);
    }
}
