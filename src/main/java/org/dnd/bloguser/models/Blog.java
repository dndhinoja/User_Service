package org.dnd.bloguser.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Blog {
    private Long id;
    private String blogTitle;
    private String blogCreator;
    private int yearOfPost;
}
