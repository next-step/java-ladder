package nextstep.ladder.domain;

public class Participant {
    public static final int MAX_NAME_LENGTH = 5;

    private final String name;

    public Participant(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("이름은 최대 " + MAX_NAME_LENGTH + "글자입니다.");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return String.format("%-5s", name);
    }

}
