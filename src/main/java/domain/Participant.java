package domain;

import java.util.Objects;

public class Participant {

    private static final int MAXIMUM_LENGTH_OF_NAME = 5;
    private static final String OUTPUT_FORMAT = "%6s";
    private static final String FORBIDDEN_NAME = "all";

    private final String name;

    public Participant(String name) {
        this.name = validateName(name);
    }

    private String validateName(String name) {
        if (name.length() > MAXIMUM_LENGTH_OF_NAME) {
            throw new IllegalArgumentException("이름은 5자 이하여야 한다.");
        }

        if (FORBIDDEN_NAME.equals(name)) {
            throw new IllegalArgumentException("all 은 이름으로 사용할 수 없다");
        }

        return name;
    }

    @Override
    public String toString() {
        return String.format(OUTPUT_FORMAT, name);
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
}
