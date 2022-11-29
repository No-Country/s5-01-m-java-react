package com.fourjuniors.juniors.repository;

import com.fourjuniors.juniors.model.entity.Rating;
import com.fourjuniors.juniors.model.enums.RatingEnum;
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
public class RatingRepositoryTests {

    @Autowired
    private RatingRepository ratingRepo;

    private Rating rating;

    @BeforeEach
    void setUp() {
        rating = Rating.builder()
                .value(RatingEnum.FIVE_STARS)
                .isRated(true)
                .build();
    }

    @DisplayName("Test para guardar un rating")
    @Test
    @Order(1)
    void testSaveRating() {
        //when
        Rating savedRating = ratingRepo.save(rating);
        //then
        assertThat(savedRating).isNotNull();
        assertThat(savedRating.getId()).isGreaterThan(0);
    }

    @DisplayName("Test para listar los ratings")
    @Test
    @Order(2)
    void testListRating() {
        //given
        Rating rating1 = Rating.builder()
                .isRated(true)
                .value(RatingEnum.THREE_STARS)
                .build();
        ratingRepo.save(rating);
        ratingRepo.save(rating1);
        //when
        List<Rating> ratingList = ratingRepo.findAll();
        //then
        assertThat(ratingList).isNotNull();
        assertThat(ratingList.size()).isEqualTo(2);
    }

    @DisplayName("Test para obtener un rating por ID")
    @Test
    @Order(3)
    void tesGetRatingById() {
        ratingRepo.save(rating);

        //when
        Rating ratingDB = ratingRepo.findById(rating.getId()).get();

        //then
        assertThat(ratingDB).isNotNull();
    }

    @DisplayName("Test para actualizar un rating")
    @Test
    @Order(4)
    void testUpdateRating() {
        ratingRepo.save(rating);

        //when
        Rating ratingDB = ratingRepo.findById(rating.getId()).get();
        ratingDB.setValue(RatingEnum.ONE_STAR);
        Rating updatedRating = ratingRepo.save(ratingDB);

        //then
        assertThat(updatedRating.getValue()).isEqualTo(RatingEnum.ONE_STAR);
    }

    @DisplayName("Test para eliminar un rating")
    @Test
    @Order(5)
    void testDeleteRating() {
        ratingRepo.save(rating);

        //when
        ratingRepo.deleteById(rating.getId());
        Optional<Rating> ratingOptional = ratingRepo.findById(rating.getId());

        //then
        assertThat(ratingOptional).isEmpty();
    }
}
