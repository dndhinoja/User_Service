package org.dnd.bloguser.controllers;

import lombok.extern.slf4j.Slf4j;
import org.dnd.bloguser.entities.User;
import org.dnd.bloguser.models.RestTemplateUserBlog;
import org.dnd.bloguser.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {

    @Autowired
    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/user", produces = "application/json", consumes = "application/json")
    public ResponseEntity<User> saveUser(@RequestBody User user){
        log.info("Save user in Controller");
        return new ResponseEntity<User>(userService.saveUser(user), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RestTemplateUserBlog> getUserByIdWithBlog(@PathVariable("id") Long userId){
        return new ResponseEntity<RestTemplateUserBlog>(userService.getUserByIdWithBlog(userId), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable("id") Long id){
        return null;
    }
}
