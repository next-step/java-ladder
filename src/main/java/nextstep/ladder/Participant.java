package nextstep.ladder;

import java.util.Objects;

public class Participant {
    public static final int MAX = 5;
    private final String name;

    private Participant(String input) {
        this.name = input;
    }

    public static Participant from(String input) {
        if (isNullOrEmpty(input)) {
            throw new IllegalArgumentException("이름을 입력해주세요.");
        }

        if (isMoreThanLimit(input)) {
            throw new IllegalArgumentException("이름은 5글자 이하로 입력해주세요.");
        }

        return new Participant(input);
    }

    private static boolean isNullOrEmpty(String input) {
        return input == null || input.length() == 0;
    }

    private static boolean isMoreThanLimit(String input) {
        return input.length() > MAX;
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
