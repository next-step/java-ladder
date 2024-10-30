package nextstep.ladder.domain;

public class Participant {
    private final String name;

    public Participant(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("참가자 이름은 null이거나 빈 문자열일 수 없습니다.");
        }
    }
}
