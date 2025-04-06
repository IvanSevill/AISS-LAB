package aiss.laboratorio3.ejercicio3.service;

import aiss.laboratorio3.ejercicio3.model.User;
import aiss.laboratorio3.ejercicio3.model.UserList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.List;

@Service
public class UserService {

    RestTemplate restTemplate;

    @Autowired
    public UserService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<User> findAllUsers() throws IOException {
        List<User> users = null;
        String url = "http://reqres.in/api/users";
        UserList userList = restTemplate.getForObject(url, UserList.class);
        users = userList.getData();
        return users;
    }
}
