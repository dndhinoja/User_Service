package org.dnd.bloguser.services;

import lombok.extern.slf4j.Slf4j;
import org.dnd.bloguser.entities.User;
import org.dnd.bloguser.models.Blog;
import org.dnd.bloguser.models.RestTemplateUserBlog;
import org.dnd.bloguser.repositories.UserRepository;
import org.dnd.bloguser.utils.RequestResponseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    RestTemplate restTemplate;


    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User saveUser(User user) {
        log.info("Save user in service");
        return userRepository.save(user);
    }

    @Override
    public RestTemplateUserBlog getUserByIdWithBlog(Long userId){
        User user = userRepository.findById(userId).orElseThrow(()-> new RuntimeException());
        Long blogId = user.getBlogId();

        HttpEntity<String> httpEntity = RequestResponseUtils.getStringHttpEntity();
        Map<String, Long> map = new HashMap<>();
        map.put("id", blogId);
        ResponseEntity<Blog> blogResponseEntity= restTemplate.exchange("http://BLOG-SERVICE/blogs/{id}", HttpMethod.GET, httpEntity, Blog.class, map);
        Blog blog = blogResponseEntity.getBody();

        return new RestTemplateUserBlog(user, blog);
    }

}
