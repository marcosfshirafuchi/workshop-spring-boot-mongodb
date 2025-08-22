package com.marcosshirafuchi.workshopmongo.services;

import com.marcosshirafuchi.workshopmongo.domain.Post;
import com.marcosshirafuchi.workshopmongo.repository.PostRepository;
import com.marcosshirafuchi.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PostService {
    @Autowired
    private PostRepository repo;



    public Post findById(String id){
        Optional<Post> post = repo.findById(id);
        if(post.isEmpty()){
            throw new ObjectNotFoundException("Objeto não encontrado");
        }
        return post.orElse(null);
    }

}
