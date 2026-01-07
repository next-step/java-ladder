package nextstep.laddergame.domain;

public record Participant(String name) {

    public static final int NAME_MAX_LENGTH = 5;

    public Participant {
        validate(name);
    }

    private void validate(String name) {
        if (name == null || name.isEmpty() || name.length() > NAME_MAX_LENGTH) {
            throw new IllegalArgumentException("참가자의 이름은 1자에서 5자 사이여야 합니다.");
        }
    }
}
