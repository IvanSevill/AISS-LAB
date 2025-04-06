package aiss.laboratorio3.ejercicio4.service;

import aiss.laboratorio3.ejercicio4.model.User;
import aiss.laboratorio3.ejercicio4.model.UserDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserDetailService {
    RestTemplate restTemplate;

    @Autowired
    public UserDetailService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public User findUserById(int id){
        User user = null;
        String url = "http://reqres.in/api/users/"+id;
        UserDetail foundUser = restTemplate.getForObject(url, UserDetail.class);
        user = foundUser.getData();
        return user;
    }
}
