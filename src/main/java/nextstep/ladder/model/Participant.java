package nextstep.ladder.model;

public class Participant {

    private static final Integer MIN_NAME_LENGTH = 1;
    private static final Integer MAX_NAME_LENGTH = 5;

    private final String name;

    public Participant(String name) {
        validateNameLength(name);
        this.name = name;
    }

    private void validateNameLength(String name) {
        if (name.length() < MIN_NAME_LENGTH || name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("0글자 이하이거나 5글자를 초과하는 참가자 이름이 포함되어 있습니다.");
        }
    }

    public String getName() {
        return name;
    }
}
