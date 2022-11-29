package com.fourjuniors.juniors.repository;

import com.fourjuniors.juniors.security.model.entity.Role;
import com.fourjuniors.juniors.security.model.enums.RoleEnum;
import com.fourjuniors.juniors.security.repository.RoleRepository;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class RoleRepositoryTests {

    @Autowired
    private RoleRepository roleRepo;

    private Role role;

    @BeforeEach
    void setUp() {
        role = Role.builder()
                .name(RoleEnum.ROLE_USER)
                .build();
    }

    @DisplayName("Test para guardar un rol")
    @Test
    @Order(1)
    void testSaveRole() {
        //when
        Role savedRole = roleRepo.save(role);
        //then
        assertThat(savedRole).isNotNull();
        assertThat(savedRole.getId()).isGreaterThan(0);
    }

    @DisplayName("Test para listar los roles de usuario")
    @Test
    @Order(2)
    void testListRole() {
        //when
        List<Role> roleList = roleRepo.findAll();
        //then
        assertThat(roleList).isNotNull();
        assertThat(roleList.size()).isEqualTo(2);
    }

    @DisplayName("Test para obtener un rol por ID")
    @Test
    @Order(3)
    void tesGetRoleById() {
        roleRepo.save(role);

        //when
        Role roleDB = roleRepo.findById(role.getId()).get();

        //then
        assertThat(roleDB).isNotNull();
    }

    @DisplayName("Test para actualizar un rol")
    @Test
    @Order(4)
    void testUpdateRole() {
        roleRepo.save(role);

        //when
        Role roleDB = roleRepo.findById(role.getId()).get();
        roleDB.setName(RoleEnum.ROLE_ADMIN);
        Role updatedRole = roleRepo.save(roleDB);

        //then
        assertThat(updatedRole.getName()).isEqualTo(RoleEnum.ROLE_ADMIN);
    }

    @DisplayName("Test para eliminar un rol")
    @Test
    @Order(5)
    void testDeleteRoles() {
        roleRepo.save(role);

        //when
        roleRepo.deleteById(role.getId());
        Optional<Role> roleOptional = roleRepo.findById(role.getId());

        //then
        assertThat(roleOptional).isEmpty();
    }

}
