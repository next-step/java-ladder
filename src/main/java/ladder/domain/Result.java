package ladder.domain;

public class Result {
    private final String value;

    public Result(String value) {
        if (value == null || value.trim().isEmpty() || value.trim().length() > 5) {
            throw new IllegalArgumentException("결과는 공백이거나 5글자를 초과할 수 없습니다.");
        }
        this.value = value.trim();
    }

    public String value() {
        return value;
    }
}
