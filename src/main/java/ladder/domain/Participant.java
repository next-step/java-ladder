package ladder.domain;

import java.util.Objects;

public class Participant {

    public static final String PARTICIPANT_NAME_IS_NULL = "참가자의 이름을 입력해야 합니다.";
    public static final String PARTICIPANT_NAME_OVER_LIMIT = "이름은 5글자까지만 입력 가능합니다.";
    public static final int NAME_LENGTH_LIMIT = 5;

    private final String name;

    public Participant(String name) {
        this.name = participantValidation(name);
    }

    public String getName() {
        return this.name;
    }


    public static Participant from(String name) {
        return new Participant(name);
    }

    private String participantValidation(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException(PARTICIPANT_NAME_IS_NULL);
        }

        if (name.length() > NAME_LENGTH_LIMIT) {
            throw new IllegalArgumentException(PARTICIPANT_NAME_OVER_LIMIT);
        }

        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Participant that = (Participant) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
