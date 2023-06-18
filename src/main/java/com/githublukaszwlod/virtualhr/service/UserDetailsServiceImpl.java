package com.githublukaszwlod.virtualhr.service;

import com.githublukaszwlod.virtualhr.config.UserDetailsImp;
import com.githublukaszwlod.virtualhr.model.Employee;
import com.githublukaszwlod.virtualhr.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {

   @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        Long employeeNumber = Long.valueOf(userName);
        Optional<Employee> user = employeeRepository.findById(employeeNumber);
        user.orElseThrow(() ->new  UsernameNotFoundException ("Not found: "+ userName) );
        return user.map(UserDetailsImp::new).get();
    }
}
