package aiss.laboratorio3.ejercicio4.service;

import aiss.laboratorio3.ejercicio4.model.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest
class UserServiceTest3_4 {

    @Autowired
    UserDetailService service;

    @Test
    @DisplayName("Get user ID")
    void findUserById() {
        int id = 2;
        User user = service.findUserById(id);
        System.out.println(user.getFirstName() +" "+ user.getLastName()+":");
        System.out.println("ID: "+user.getId()+" - Email: "+ user.getEmail()+" \nAvatar: "+ user.getAvatar()+"\n");
    }
}