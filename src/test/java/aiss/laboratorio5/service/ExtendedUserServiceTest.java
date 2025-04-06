package aiss.laboratorio5.service;

import aiss.laboratorio5.model.User;
import aiss.laboratorio5.model.UserDetail;
import aiss.laboratorio5.model.UserList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class ExtendedUserServiceTest {

    @Autowired
    ExtendedUserService service;

    void notNullUser(User user) {
        assertNotNull(user);
        assertNotNull(user.getFirstName());
        assertNotNull(user.getLastName());
        assertNotNull(user.getEmail());
        assertNotNull(user.getAvatar());
    }

    void imprimirUsuario(User user) {
        System.out.println(user.getFirstName() + " " + user.getLastName() + ":");
        System.out.println("ID: " + user.getId() + " - Email: " + user.getEmail() + " \nAvatar: " + user.getAvatar() + "\n");
    }

    void imprimirUsuarioStatus(ResponseEntity<User> response) {
        User postedUserResponse = response.getBody();

        System.out.println("Name: " + postedUserResponse.getFirstName() + " " + postedUserResponse.getLastName());
        System.out.println("ID: " + postedUserResponse.getId() + " - Email: " + postedUserResponse.getEmail());
        System.out.println(response.getStatusCode());
    }

    @Test
    @DisplayName("Get a user by ID")
    void findUserById() {
        int id = 2;
        User user = service.findUserById(id);

        // Comprobaciones del test
        notNullUser(user);

        // Imprimir el usuario
        imprimirUsuario(user);
    }

    @Test
    @DisplayName("Get all users")
    void getAllUsers() {
        List<User> users = service.getAllUsers();
        for (User user : users) {

            // Comprobaciones del test
            notNullUser(user);

            // Imprimir el usuario
            imprimirUsuario(user);
        }
    }

    @Test
    @DisplayName("Post a new user")
    public void postNewUser() throws IOException {
        User toPostUser = new User();
        toPostUser.setFirstName("John");
        toPostUser.setLastName("Doe");
        toPostUser.setEmail("john@doe.com");
        toPostUser.setAvatar("https://reqres.in/img/faces/1-image.jpg");

        ResponseEntity<User> response = service.postNewUser(toPostUser);
        notNullUser(response.getBody());
        imprimirUsuarioStatus(response);
    }

    @Test
    @DisplayName("Update successfully a user")
    public void updateUser() throws IOException {
        // Obtengo un usuario y lo edito
        User userToUpdate = service.findUserById(2);
        userToUpdate.setFirstName("Noex");
        userToUpdate.setLastName("Isto");

        // Actualizo el usuario
        ResponseEntity<User> response = service.updateUser(userToUpdate);

        // Comprobaciones del test
        assertNotNull(response.getBody());

        // Imprimir el usuario
        System.out.println("Updated user:");
        imprimirUsuarioStatus(response);

    }

    @Test
    @DisplayName("Delete successfully a user")
    public void deleteUser() throws IOException {
        ResponseEntity<User> response = service.deleteUser(2);
        // Comprobaciones del test
        assertEquals( 204, response.getStatusCodeValue());
        System.out.println("Status code: " + response.getStatusCode());
    }
}
