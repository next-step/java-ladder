package nextstep.ladder.domain;

public class Participant {
    public static final String NULL_OR_EMPTY_ERROR_MESSAGE = "이름은 null 이거나 빈 문자열일 수 없습니다";
    public static final String TOO_LENGTH_ERROR_MESSAGE = "이름은 1자 이상 5자 이하로 입력해야 합니다";
    private final String value;

    public Participant(String name) {
        this.valid(name);
        this.value = name;
    }

    private void valid(String name) {
        if (name.trim().isEmpty()) {
            throw new IllegalArgumentException(NULL_OR_EMPTY_ERROR_MESSAGE);
        }

        if (name.length() > 5) {
            throw new IllegalArgumentException(TOO_LENGTH_ERROR_MESSAGE + " - " + name);
        }
    }

    public String getName() {
        return value;
    }
}
