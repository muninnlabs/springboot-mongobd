package com.munninlabs.springmongo.services;

import com.munninlabs.springmongo.domain.Post;
import com.munninlabs.springmongo.domain.User;
import com.munninlabs.springmongo.dto.UserDTO;
import com.munninlabs.springmongo.repository.PostRepository;
import com.munninlabs.springmongo.repository.UserRepository;
import com.munninlabs.springmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public Post findById(String id) {
            return postRepository.findById(id)
                    .orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado aaa"));
    }

    public List<Post> findByTitle(String text) {
        return postRepository.findByTitle(text);
    }

    public List<Post> fullSearch(String text, Date minDate, Date maxDate) {
        maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000);
//        maxDate = new Date.from(maxDate.toInstant().plus(1, ChronoUnit.DAYS));
        return postRepository.fullSearch(text, minDate, maxDate);
    }

//    public List<Post> findByTitle(String text) {
//        return postRepository.findByTitleContainingIgnoreCase(text);
//    }
}
