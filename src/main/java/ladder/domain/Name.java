package ladder.domain;

public class Name {

    private static final int NAME_LENGTH_LIMIT = 5;
    private final String value;

    public Name(String value) {
        if (isEmptyOrNull(value)) {
            throw new IllegalArgumentException("한 글자 이상의 이름을 입력해주세요.");
        }
        validateTextLengthLimitOver(value);
        this.value = value;
    }

    private boolean isEmptyOrNull(String text) {
        return text == null || text.isEmpty();
    }

    private void validateTextLengthLimitOver(String value) {
        if (value.length() > NAME_LENGTH_LIMIT) {
            throw new IllegalArgumentException("이름은 " + NAME_LENGTH_LIMIT + "자 이하만 입력가능합니다.");
        }
    }

    @Override
    public String toString() {
        return value;
    }
}
