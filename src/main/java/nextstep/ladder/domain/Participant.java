package nextstep.ladder.domain;

import nextstep.ladder.exception.CannotRegisterNameException;

public class Participant {

    public static final int MIN_NAME_LENGTH = 1;
    public static final int MAX_NAME_LENGTH = 5;
    private String name;


    public static Participant nameOf(String name) {
        validateNameLength(name.trim());
        return new Participant(name.trim());
    }

    private Participant(String name) {
        this.name = name;
    }

    private static void validateNameLength(String name) {
        if (name.length() < 1) {
            throw new CannotRegisterNameException(String.format("이름은 %d 글자 이상이어야 합니다.", Participant.MIN_NAME_LENGTH));
        }
        if (name.length() > 5) {
            throw new CannotRegisterNameException(String.format("이름은 %d 글자를 초과할 수 없습니다.", Participant.MAX_NAME_LENGTH));
        }
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Participant{" +
                "name='" + name + '\'' +
                '}';
    }
}
