package nextstep.laddergame.domain.participant;

public record Name(String value) {

    public static final int NAME_MAX_LENGTH = 5;

    public Name {
        validate(value);
    }

    private void validate(String value) {
        if (value == null || value.isEmpty() || value.length() > NAME_MAX_LENGTH) {
            throw new IllegalArgumentException("참가자의 이름은 1자에서 5자 사이여야 합니다.");
        }
    }
}
