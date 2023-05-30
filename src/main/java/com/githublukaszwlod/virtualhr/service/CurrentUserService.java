package com.githublukaszwlod.virtualhr.service;


import lombok.NoArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
@NoArgsConstructor
@Service
public class CurrentUserService {

    public Long getCurrentUserId(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Long currentUserId = Long.valueOf(authentication.getName());
        return currentUserId;

    }
}
