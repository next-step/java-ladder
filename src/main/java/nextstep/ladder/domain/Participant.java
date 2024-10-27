package nextstep.ladder.domain;

public class Participant {

    private static final int MAX_NAME_LENGTH = 5;

    private final String name;

    public Participant(String name) {
        validateNameLength(name);
        this.name = name;
    }

    private void validateNameLength(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("이름은 최대5글자까지 허용합니다.");
        }
    }
}
