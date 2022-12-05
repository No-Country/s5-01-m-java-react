package com.fourjuniors.juniors.model.dto.request;

import lombok.*;

import javax.validation.constraints.NotBlank;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
public class RatingRequest {
    @NotBlank(message = "rating is mandatory")
    private double rating;
}
