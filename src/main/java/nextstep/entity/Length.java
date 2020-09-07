package nextstep.entity;

public class Length {

    private final int length;

    public Length(int length) {
        validate(length);
        this.length = length;
    }

    private void validate(int length) {
        if (length < 1) {
            throw new IllegalArgumentException("사다리 높이는 최소 1 단위 까지 부여할 수 있어요.");
        }
    }

    public int getLength() {
        return length;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Length length1 = (Length) o;

        return length == length1.length;
    }

    @Override
    public int hashCode() {
        return length;
    }
}
