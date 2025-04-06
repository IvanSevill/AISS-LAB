package aiss.laboratorio5.service;

import aiss.laboratorio5.model.User;
import aiss.laboratorio5.model.UserDetail;
import aiss.laboratorio5.model.UserList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class ExtendedUserService {

    RestTemplate restTemplate;

    @Autowired
    public ExtendedUserService(RestTemplate restTemplate) { this.restTemplate = restTemplate; }

    // Funciona
    public User findUserById(int id){
        User user = null;
        String url = "http://reqres.in/api/users/"+id;
        HttpEntity<UserDetail> foundUser = restTemplate.exchange(url, HttpMethod.GET, null, UserDetail.class);;
        return foundUser.getBody().getData();
    }

    // Funciona
    public List<User> getAllUsers() {
        List<User> users = null;
        String url = "http://reqres.in/api/users";
        HttpEntity<UserList> request = restTemplate.exchange(url, HttpMethod.GET,null, UserList.class);
        users = request.getBody().getData().stream().toList();
        return users;
    }

    // No funciona
    public ResponseEntity<User> postNewUser(User user) {
        String url = "https://reqres.in/api/users";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<User> request = new HttpEntity<>(user, headers);
        return restTemplate.exchange(url, HttpMethod.POST, request, User.class);
    }

    // No funciona
    public ResponseEntity<User> updateUser(User inputUser){
        String url = "https://reqres.in/api/users/"+inputUser.getId();
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<User> request = new HttpEntity<>(inputUser, headers);
        return restTemplate.exchange(url, HttpMethod.POST, request, User.class);
    }

    // No funciona
    public ResponseEntity<User> deleteUser(int id){
        String url = "http://reqres.in/api/users/"+id;
        HttpEntity<User> request = new HttpEntity<>(null);
        ResponseEntity<User> response = restTemplate.exchange(url, HttpMethod.DELETE, request, User.class);
        return response;
    }

}
