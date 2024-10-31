package nextstep.ladder.domain;

public class Participant {
    private static final int MAX_NAME_LENGTH = 5;

    private final String name;

    public Participant(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("참가자 이름은 null이거나 빈 문자열일 수 없습니다.");
        }
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("참가자 이름은 5자를 초과할 수 없습니다.");
        }
    }

    public String getFormattedName() {
        return String.format("%-" + MAX_NAME_LENGTH + "s", name);
    }
}
