package com.fourjuniors.juniors.model.entity;


import com.fourjuniors.juniors.model.enums.RatingEnum;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private boolean isRated;

    @Enumerated(value = EnumType.STRING)
    RatingEnum value;
}
