package com.fourjuniors.juniors.repository;

import com.fourjuniors.juniors.model.entity.Image;
import com.fourjuniors.juniors.model.entity.Project;
import com.fourjuniors.juniors.model.entity.Rating;
import com.fourjuniors.juniors.model.entity.UsersProjects;
import com.fourjuniors.juniors.model.enums.RatingEnum;
import com.fourjuniors.juniors.security.model.entity.Role;
import com.fourjuniors.juniors.security.model.entity.User;
import com.fourjuniors.juniors.security.model.enums.RoleEnum;
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
public class UsersProjectsRepositoryTests {

    @Autowired
    private UsersProjectsRepository usersProjectsRepo;

    private PasswordEncoder passwordEncoder;

    private UsersProjects userProject;

    private Image image;

    private User user;

    private Project project;

    private Rating rating;

    @BeforeEach
    void setUp() {

        passwordEncoder = new BCryptPasswordEncoder();

        List<Role> roles = new ArrayList<>();
        roles.add(Role.builder()
                .name(RoleEnum.ROLE_USER)
                .build());

        image = Image.builder()
                .path("https://i.postimg.cc/zX6KbcdK/Mockup-Edificio.png")
                .build();

        user = User.builder()
                .email("johndoe@mail.com")
                .password(passwordEncoder.encode("12345"))
                .name("John")
                .lastname("Doe")
                .profile("UI")
                .stack("Figma, illustrator.")
                .experience("De 6 a 12 meses")
                .portfolio("https://www.behance.net/search/projects/?search=john+doe&locale=es_ES")
                .roles(roles)
                .build();

        project = Project.builder()
                .name("Projecto 4juniors")
                .type("Galería de Proyectos")
                .stack("React Java")
                .description("Los proyectos que llevamos a cabo en NoCountry muchas veces quedan en la nada luego de la demo day. Es por esta razón que nace la idea de crear una plataforma para darles visibilidad y que otros usuarios puedan puntuarlos/votarlos.")
                .link("https://github.com/No-Country/s5-01-m-java-react")
                .image(Image.builder()
                        .path("https://i.postimg.cc/zX6KbcdK/Mockup-Edificio.png")
                        .build())
                .build();

        rating = Rating.builder()
                .value(RatingEnum.FIVE_STARS)
                .isRated(true)
                .build();

        userProject = UsersProjects.builder()
                .project(project)
                .user(user)
                .rating(rating)
                .build();
    }

    @DisplayName("Test para guardar un userProject")
    @Test
    @Order(1)
    void testSaveUserProject() {
        //when
        UsersProjects savedUserProject = usersProjectsRepo.save(userProject);
        //then
        assertThat(savedUserProject).isNotNull();
        assertThat(savedUserProject.getId()).isGreaterThan(0);
    }

    @DisplayName("Test para listar los userProjects")
    @Test
    @Order(2)
    void testListUsersProjects() {
        usersProjectsRepo.save(userProject);

        //when
        List<UsersProjects> usersProjectsList = usersProjectsRepo.findAll();

        //then
        assertThat(usersProjectsList).isNotNull();
        assertThat(usersProjectsList.size()).isEqualTo(1);
    }

    @DisplayName("Test para obtener un userProject por ID")
    @Test
    @Order(3)
    void testGetUserProjectById() {
        usersProjectsRepo.save(userProject);

        //when
        UsersProjects userProjectDB = usersProjectsRepo.findById(userProject.getId()).get();

        //then
        assertThat(userProjectDB).isNotNull();
    }

    @DisplayName("Test para actualizar un userProject")
    @Test
    @Order(4)
    void testUpdateUserProject() {
        usersProjectsRepo.save(userProject);
        Rating newRating = Rating.builder()
                .value(RatingEnum.FOUR_STARS)
                .isRated(true)
                .build();

        //when
        UsersProjects userProjectDB = usersProjectsRepo.findById(userProject.getId()).get();
        userProjectDB.setRating(newRating);
        UsersProjects updatedUserProject = usersProjectsRepo.save(userProjectDB);

        //then
        assertThat(updatedUserProject.getRating().getValue()).isEqualTo(RatingEnum.FOUR_STARS);
    }

    @DisplayName("Test para eliminar un userProject")
    @Test
    @Order(5)
    void testDeleteUserProject() {
        usersProjectsRepo.save(userProject);

        //when
        usersProjectsRepo.deleteById(userProject.getId());
        Optional<UsersProjects> usersProjectsOptional = usersProjectsRepo.findById(userProject.getId());

        //then
        assertThat(usersProjectsOptional).isEmpty();
    }
}
