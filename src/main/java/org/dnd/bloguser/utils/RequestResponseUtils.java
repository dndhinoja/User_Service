package org.dnd.bloguser.utils;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import java.util.ArrayList;
import java.util.List;

public class RequestResponseUtils {

    public static HttpEntity<String> getStringHttpEntity() {
        HttpHeaders httpHeaders = new HttpHeaders();
        List<MediaType> list = new ArrayList<>();
        list.add(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(list);
        HttpEntity<String> httpEntity = new HttpEntity<>(String.valueOf(httpHeaders));
        return httpEntity;
    }
}
