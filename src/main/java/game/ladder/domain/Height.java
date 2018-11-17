package game.ladder.domain;

import spark.utils.Assert;

public class Height {
    public static final int MIN = 0;
    private final int value;

    public Height(int value) {
        Assert.isTrue(value > MIN, "높이는 0보다 큰 숫자여야 합니다.");
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Height height = (Height) o;

        return value == height.value;
    }

    @Override
    public int hashCode() {
        return value;
    }
}
