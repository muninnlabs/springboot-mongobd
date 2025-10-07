package com.munninlabs.springmongo.services;

import com.munninlabs.springmongo.domain.Post;
import com.munninlabs.springmongo.domain.User;
import com.munninlabs.springmongo.dto.UserDTO;
import com.munninlabs.springmongo.repository.PostRepository;
import com.munninlabs.springmongo.repository.UserRepository;
import com.munninlabs.springmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public Post findById(String id) {
            return postRepository.findById(id)
                    .orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado aaa"));
    }

}
