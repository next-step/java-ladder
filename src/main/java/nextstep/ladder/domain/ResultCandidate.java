package nextstep.ladder.domain;

import java.util.function.Consumer;

public class ResultCandidate {
    public static final String INVALID_RESULT_LENGTH_ERR_MSG = "실행결과는 1글자 이상 5글자 이하만 허용합니다.";
    private static final int MIN_AVAILABLE_LENGTH = 1;
    private static final int MAX_AVAILABLE_LENGTH = 5;
    private final String value;

    private ResultCandidate(String value) {
        this.value = value;
        validateLength();
    }

    public static ResultCandidate valueOf(String value) {
        return new ResultCandidate(value);
    }

    private void validateLength() {
        int length = value.length();
        if (length < MIN_AVAILABLE_LENGTH || length > MAX_AVAILABLE_LENGTH) {
            throw new IllegalArgumentException(INVALID_RESULT_LENGTH_ERR_MSG);
        }
    }

    public String getValue() {
        return value;
    }

    public void accept(Consumer<String> consumer) {
        consumer.accept(value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ResultCandidate)) return false;

        ResultCandidate resultCandidate = (ResultCandidate) o;

        return value.equals(resultCandidate.value);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    @Override
    public String toString() {
        return "ResultCandidate{" +
                "value='" + value + '\'' +
                '}';
    }
}
