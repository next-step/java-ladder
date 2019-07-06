package ladder.model;

public class Participant {
    public static final int MAX_LENGTH = 5;

    private final String name;

    public Participant(String name) {
        if (name.length() > MAX_LENGTH) {
            throw new IllegalArgumentException("참가자의 이름은 5글자를 넘을 수 없습니다.");
        }
        this.name = name;
    }
}
