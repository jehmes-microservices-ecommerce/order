package com.ecommerce.order.services;

import com.ecommerce.order.models.User;
import com.ecommerce.order.repositories.UserRepository;
import com.ecommerce.order.services.interfaces.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }
}
