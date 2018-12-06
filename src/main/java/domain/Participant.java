package domain;

import java.util.Objects;

class Participant {

    private static final int LENGTH_BOUND = 5;
    private static final String OUTPUT_FORMAT = "%6s";
    private static final String NOT_ALLOWED_NAME = "all";

    private final String name;

    Participant(String name) {
        this.name = validate(name);
    }

    private String validate(String name) {
        if (NOT_ALLOWED_NAME.equals(name)) {
            throw new IllegalArgumentException("all 은 이름으로 사용불가임.");
        }

        if (name.length() > LENGTH_BOUND) {
            throw new IllegalArgumentException("참여자 명 5자 이내여야함.");
        }

        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Participant that = (Participant) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return String.format(OUTPUT_FORMAT, name);
    }
}
