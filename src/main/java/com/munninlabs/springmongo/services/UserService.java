package com.munninlabs.springmongo.services;

import com.munninlabs.springmongo.domain.User;
import com.munninlabs.springmongo.repository.UserRepository;
import com.munninlabs.springmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll(){
        return userRepository.findAll();
    }



    public User findById(String id) {
            return userRepository.findById(id)
                    .orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado aaa"));

    }
}
