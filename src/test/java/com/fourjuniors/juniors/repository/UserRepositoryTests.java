package com.fourjuniors.juniors.repository;

import com.fourjuniors.juniors.security.model.entity.Role;
import com.fourjuniors.juniors.security.model.entity.User;
import com.fourjuniors.juniors.security.model.enums.RoleEnum;
import com.fourjuniors.juniors.security.repository.UserRepository;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UserRepositoryTests {

    @Autowired
    private UserRepository userRepo;

    private User user;

    private PasswordEncoder passwordEncoder;

    @BeforeEach
    void setUp() {
        List<Role> roles = new ArrayList<>();
        roles.add(Role.builder()
                .name(RoleEnum.ROLE_USER)
                .build());
        passwordEncoder = new BCryptPasswordEncoder();
        user = User.builder()
                .email("johndoe@mail.com")
                .password(passwordEncoder.encode("12345"))
                .name("John")
                .lastname("Doe")
                .profile("backend")
                .stack("Java, Spring")
                .portfolio("www.portfolio.com")
                .experience("de 4 a 6 meses")
                .roles(roles)
                .build();
    }

    @DisplayName("Test para guardar un usuario")
    @Test
    @Order(1)
    void testSaveUser() {
        //when
        User savedUser = userRepo.save(user);
        //then
        assertThat(savedUser).isNotNull();
        assertThat(savedUser.getId()).isGreaterThan(0);
    }

    @DisplayName("Test para listar los suarios")
    @Test
    @Order(2)
    void testListUsers() {
        //when
        List<User> userList = userRepo.findAll();
        //then
        assertThat(userList).isNotNull();
        assertThat(userList.size()).isEqualTo(1);
    }

    @DisplayName("Test para obtener un usuario por ID")
    @Test
    @Order(3)
    void tesGetUserById() {
        userRepo.save(user);

        //when
        User userDB = userRepo.findById(user.getId()).get();

        //then
        assertThat(userDB).isNotNull();
    }

    @DisplayName("Test para actualizar un usuario")
    @Test
    @Order(4)
    void testUpdateUser() {
        userRepo.save(user);

        //when
        User userDB = userRepo.findById(user.getId()).get();
        userDB.setName("Johnatan Doe");
        User updatedUser = userRepo.save(userDB);

        //then
        assertThat(updatedUser.getName()).isEqualTo("Johnatan Doe");
    }

    @DisplayName("Test para eliminar un usuario")
    @Test
    @Order(5)
    void testDeleteUser() {
        userRepo.save(user);

        //when
        userRepo.deleteById(user.getId());
        Optional<User> userOptional = userRepo.findById(user.getId());

        //then
        assertThat(userOptional).isEmpty();
    }
}
