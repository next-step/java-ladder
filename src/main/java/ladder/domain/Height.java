package ladder.domain;

import java.util.Objects;

public class Height {

    private static final int MINIMUM_HEIGHT_LENGTH = 1;

    private final int length;

    private Height(int length) {
        this.length = length;
    }

    public static Height create(int length) {
        validate(length);
        return new Height(length);
    }

    private static void validate(int length) {
        if(length < MINIMUM_HEIGHT_LENGTH){
            throw new IllegalArgumentException("사다리의 세로길이는 1 이상이어야 합니다.");
        }
    }

    public int getLength() {
        return length;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Height height = (Height) o;
        return length == height.length;
    }

    @Override
    public int hashCode() {
        return Objects.hash(length);
    }
}
