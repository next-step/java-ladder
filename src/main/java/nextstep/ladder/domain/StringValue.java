package nextstep.ladder.domain;

public class StringValue {
    private static final int MAX_LENGTH = 5;
    private static final String CREATE_NAME_ERROR = "사다리 게잉에서 글자는 " + MAX_LENGTH + "자리 수 이하여야 합니다.";

    private final String value;

    public StringValue(final String value) {
        if (value.isEmpty() || value.length() > MAX_LENGTH) {
            throw new IllegalArgumentException(CREATE_NAME_ERROR);
        }
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
