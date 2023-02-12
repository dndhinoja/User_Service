package org.dnd.bloguser.services;

import org.dnd.bloguser.entities.User;
import org.dnd.bloguser.models.RestTemplateUserBlog;
import org.springframework.http.ResponseEntity;

public interface UserService {
    User saveUser(User user);

    RestTemplateUserBlog getUserByIdWithBlog(Long userId);
}
