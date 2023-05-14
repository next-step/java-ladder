package nextstep.ladder.domain;

public class Participant {
    private static final int MAX_NAME_LENGTH = 5;
    private final String name;

    public Participant(String name) {
        validateParticipantName(name);

        this.name = name;
    }

    public String getName() {
        return name;
    }

    private void validateParticipantName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("이름이 입력되지 않았습니다.");
        }
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(String.format("이름은 최대 %d 길이까지 부여할 수 있습니다.", MAX_NAME_LENGTH));
        }
    }

}
