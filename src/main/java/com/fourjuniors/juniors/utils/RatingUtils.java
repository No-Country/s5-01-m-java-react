package com.fourjuniors.juniors.utils;

import com.fourjuniors.juniors.exception.AttributeException;
import com.fourjuniors.juniors.model.entity.Rating;
import com.fourjuniors.juniors.model.enums.RatingEnum;

import java.util.Set;

public class RatingUtils {

    public static double getAverageValue(Set<Rating> ratingSet) {

        return Math.round(ratingSet.stream()
                .mapToDouble(rating -> rating.getValue().getValueNumber())
                .average().getAsDouble() * 10) / 10d;
    }

    public static RatingEnum getRatingEnum(double value) throws AttributeException {
        if(value == RatingEnum.ONE_STAR.getValueNumber())
            return RatingEnum.ONE_STAR;

        if(value == RatingEnum.ONE_STAR_AND_HALF.getValueNumber())
            return RatingEnum.ONE_STAR_AND_HALF;

        if(value == RatingEnum.TWO_STARS.getValueNumber())
            return RatingEnum.TWO_STARS;

        if(value == RatingEnum.TWO_STARS_AND_HALF.getValueNumber())
            return RatingEnum.TWO_STARS_AND_HALF;

        if(value == RatingEnum.THREE_STARS.getValueNumber())
            return RatingEnum.THREE_STARS;

        if(value == RatingEnum.THREE_STARS_AND_HALF.getValueNumber())
            return RatingEnum.THREE_STARS_AND_HALF;

        if(value == RatingEnum.FOUR_STARS.getValueNumber())
            return RatingEnum.FOUR_STARS;

        if(value == RatingEnum.FOUR_STARS_AND_HALF.getValueNumber())
            return RatingEnum.FOUR_STARS_AND_HALF;

        if(value == RatingEnum.FIVE_STARS.getValueNumber())
            return RatingEnum.FIVE_STARS;

        throw new AttributeException("The value of " + value + " is not valid for a Rating Value");
    }
}
