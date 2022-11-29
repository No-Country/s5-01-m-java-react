package com.fourjuniors.juniors.repository;

import static org.assertj.core.api.Assertions.assertThat;

import com.fourjuniors.juniors.model.entity.Image;
import com.fourjuniors.juniors.model.entity.Project;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ProjectRepositoryTests {

    @Autowired
    private ProjectRepository projectRepo;

    private Project project;

    @BeforeEach
    void setUp() {
        project = Project.builder()
                .name("Animatch")
                .type("Red Social de Mascotas")
                .stack("React Java")
                .description("Aplicación que ayuda a encontrar pareja a nuestras mascotas.")
                .link("https://github.com/No-Country/C7-06-Back")
                .image(Image.builder()
                        .path("https://i85.servimg.com/u/f85/19/88/52/56/animat10.png")
                        .build())
                .build();
    }

    @DisplayName("Test para guardar un proyecto")
    @Test
    @Order(1)
    void testSaveProject() {

        //given - o condición previa o configuración
        Project project1 = Project.builder()
                .name("Projecto 4juniors")
                .type("Galería de Proyectos")
                .stack("React Java")
                .description("Los proyectos que llevamos a cabo en NoCountry muchas veces quedan en la nada luego de la demo day. Es por esta razón que nace la idea de crear una plataforma para darles visibilidad y que otros usuarios puedan puntuarlos/votarlos.")
                .link("https://github.com/No-Country/s5-01-m-java-react")
                .image(Image.builder()
                        .path("https://i.postimg.cc/zX6KbcdK/Mockup-Edificio.png")
                        .build())
                .build();

        //when - acción o el comportamiento que vamos a probar
        Project savedProject = projectRepo.save(project1);

        //then - verificar la salida
        assertThat(savedProject).isNotNull();
        assertThat(savedProject.getId()).isGreaterThan(0);
    }

    @DisplayName("Test para listar los proyectos")
    @Test
    @Order(2)
    void testListProjects() {
        //given
        Project project1 = Project.builder()
                .name("Projecto 4juniors")
                .type("Galería de Proyectos")
                .stack("React Java")
                .description("Los proyectos que llevamos a cabo en NoCountry muchas veces quedan en la nada luego de la demo day. Es por esta razón que nace la idea de crear una plataforma para darles visibilidad y que otros usuarios puedan puntuarlos/votarlos.")
                .link("https://github.com/No-Country/s5-01-m-java-react")
                .image(Image.builder()
                        .path("https://i.postimg.cc/zX6KbcdK/Mockup-Edificio.png")
                        .build())
                .build();
        projectRepo.save(project);
        projectRepo.save(project1);
        //when
        List<Project> projectList = projectRepo.findAll();
        //then
        assertThat(projectList).isNotNull();
        assertThat(projectList.size()).isEqualTo(2);
    }

    @DisplayName("Test para obtener un proyecto por ID")
    @Test
    @Order(3)
    void testGetProjectById() {
        projectRepo.save(project);

        //when
        Project projectDB = projectRepo.findById(project.getId()).get();
        //then
        assertThat(projectDB).isNotNull();
    }

    @DisplayName("Test para actualizar un proyecto")
    @Test
    @Order(4)
    void testUpdateProject() {
        projectRepo.save(project);

        //when
        Project savedProject = projectRepo.findById(project.getId()).get();
        savedProject.setDescription("Red social para que los dueños de perros y gatos puedan encontrar pareja a sus mascotas.");
        Project updatedProject = projectRepo.save(savedProject);

        //then
        assertThat(updatedProject.getDescription()).isEqualTo("Red social para que los dueños de perros y gatos puedan encontrar pareja a sus mascotas.");
    }

    @DisplayName("Test para eliminar un proyecto")
    @Test
    @Order(5)
    void testDeleteProject() {
        projectRepo.save(project);

        //when
        projectRepo.deleteById(project.getId());
        Optional<Project> projectOptional = projectRepo.findById(project.getId());


        //then
        assertThat(projectOptional).isEmpty();
    }

}
