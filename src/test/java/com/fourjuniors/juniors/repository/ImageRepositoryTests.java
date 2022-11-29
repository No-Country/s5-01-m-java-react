package com.fourjuniors.juniors.repository;

import static org.assertj.core.api.Assertions.assertThat;

import com.fourjuniors.juniors.model.entity.Image;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ImageRepositoryTests {

    @Autowired
    private ImageRepository imageRepo;

    private Image image;

    @BeforeEach
    void setUp() {
        image = Image.builder()
                .path("https://i.postimg.cc/zX6KbcdK/Mockup-Edificio.png")
                .build();
    }

    @DisplayName("Test para guardar una imagen")
    @Test
    @Order(1)
    void testSaveImage() {
        //when
        Image savedImage = imageRepo.save(image);
        //then
        assertThat(savedImage).isNotNull();
        assertThat(savedImage.getId()).isGreaterThan(0);
    }

    @DisplayName("Test para listar las imagenes")
    @Test
    @Order(2)
    void testListImages() {
        //given
        Image image1 = Image.builder()
                .path("https://i85.servimg.com/u/f85/19/88/52/56/animat10.png")
                .build();
        imageRepo.save(image);
        imageRepo.save(image1);
        //when
        List<Image> imageList = imageRepo.findAll();
        //then
        assertThat(imageList).isNotNull();
        assertThat(imageList.size()).isEqualTo(2);
    }

    @DisplayName("Test para obtener una imagen por ID")
    @Test
    @Order(3)
    void tesGetImageById() {
        imageRepo.save(image);

        //when
        Image imageDB = imageRepo.findById(image.getId()).get();

        //then
        assertThat(imageDB).isNotNull();
    }

    @DisplayName("Test para actualizar una imagen")
    @Test
    @Order(4)
    void testUpdateImage() {
        imageRepo.save(image);

        //when
        Image imageDB = imageRepo.findById(image.getId()).get();
        imageDB.setPath("https://http2.mlstatic.com/D_NQ_NP_603200-MLA51902971862_102022-V.jpg");
        Image updatedImage = imageRepo.save(imageDB);

        //then
        assertThat(updatedImage.getPath()).isEqualTo("https://http2.mlstatic.com/D_NQ_NP_603200-MLA51902971862_102022-V.jpg");
    }

    @DisplayName("Test para eliminar una imagen")
    @Test
    @Order(5)
    void testDeleteProject() {
        imageRepo.save(image);

        //when
        imageRepo.deleteById(image.getId());
        Optional<Image> imageOptional = imageRepo.findById(image.getId());

        //then
        assertThat(imageOptional).isEmpty();

    }
}
