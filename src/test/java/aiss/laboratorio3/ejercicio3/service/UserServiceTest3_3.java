package aiss.laboratorio3.ejercicio3.service;

import aiss.laboratorio3.ejercicio3.model.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceTest3_3 {

    @Autowired
    UserService service;

    @Test
    @DisplayName("Get all users")
    void findAllUsers() throws IOException {
        List<User> users = service.findAllUsers();
        assertFalse(users.isEmpty(), "The List of users is empty");
        for (User user : users) {
            imprimeUsuario(user);
        }
    }

    private void imprimeUsuario(User user) {
        System.out.println(user.getFirstName() +" "+ user.getLastName()+":");
        System.out.println("ID: "+user.getId()+" - Email: "+ user.getEmail()+" \nAvatar: "+ user.getAvatar()+"\n");
    }
}