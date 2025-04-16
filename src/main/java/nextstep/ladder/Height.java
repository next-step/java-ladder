package nextstep.ladder;

public class Height {

    private int value;

    public Height(int value) {
        validate(value);
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Height)) return false;
        Height height = (Height) o;
        return value == height.value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    private void validate(int value) {
        if (value < 1) {
            throw new IllegalArgumentException("Height 값은 1보다 작을 수 없습니다.");
        }
    }
}
