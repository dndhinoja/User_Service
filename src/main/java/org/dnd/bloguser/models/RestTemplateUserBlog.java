package org.dnd.bloguser.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.dnd.bloguser.entities.User;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RestTemplateUserBlog {
    private User user;
    private Blog blog;
}
