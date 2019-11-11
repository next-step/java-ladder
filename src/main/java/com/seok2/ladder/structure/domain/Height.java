package com.seok2.ladder.structure.domain;

public class Height {

    private static final int MIN = 0;
    private final int height;

    private Height(int height) {
        validate(height);
        this.height = height;
    }

    public static Height of(int height) {
        return new Height(height);
    }

    private void validate(int height) {
        if (height < MIN) {
            throw new IllegalArgumentException("사다리의 높이는 0보다 작을 수 없습니다.");
        }
    }

    public int intValue() {
        return height;
    }
}
