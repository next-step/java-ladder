package nextstep.step2.domain;

public class ParticipantName {

    private final int NAME_MAX_RANGE = 5;
    private final String name;


    private ParticipantName(String name) {
        validateName(name);
        this.name = name;
    }

    public static ParticipantName from(String name) {
        return new ParticipantName(name);
    }

    private void validateName(String name) {
        if (name.length() > NAME_MAX_RANGE) {
            throw new IllegalArgumentException("참여자 이름은 5글자 이하로 입력해야 합니다.");
        }

        if (name.equals("")) {
            throw new IllegalArgumentException("참여자 이름은 공백일 수 없습니다.");
        }
    }

    public String getName() {
        return name;
    }
}
