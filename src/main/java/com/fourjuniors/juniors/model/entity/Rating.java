package com.fourjuniors.juniors.model.entity;


import com.fourjuniors.juniors.model.enums.RatingEnum;
import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor @AllArgsConstructor
@Getter @Setter
@Builder
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private boolean isRated;

    @Enumerated(value = EnumType.STRING)
    RatingEnum value;
}
