package com.fourjuniors.juniors.model.enums;

public enum RatingEnum {
    ONE_STAR(1),
    ONE_STAR_AND_HALF(1.5),
    TWO_STARS(2),
    TWO_STARS_AND_HALF(2.5),
    THREE_STARS(3),
    THREE_STARS_AND_HALF(3.5),
    FOUR_STARS(4),
    FOUR_STARS_AND_HALF(4.5),
    FIVE_STARS(5);

    private final double valueNumber;

    RatingEnum(double valueNumber) {
        this.valueNumber = valueNumber;
    }

    public double getValueNumber() {
        return valueNumber;
    }
}
