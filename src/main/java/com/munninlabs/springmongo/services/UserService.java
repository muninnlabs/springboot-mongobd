package com.munninlabs.springmongo.services;

import com.munninlabs.springmongo.domain.User;
import com.munninlabs.springmongo.dto.UserDTO;
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

    public User insert(User obj) {
        return userRepository.insert(obj);
    }

    public User fromDTO(UserDTO objDto) {
        return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
    }

    public void delete(String id) {
        findById(id);
        userRepository.deleteById(id);
    }
}
