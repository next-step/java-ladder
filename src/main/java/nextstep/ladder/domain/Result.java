package nextstep.ladder.domain;

import java.util.Objects;

public class Result {

    private String text;

    public Result(String text) {
        validate(text);
        this.text = text;
    }

    private void validate(String text) {
        if (isBlank(text)) {
            throw new IllegalArgumentException("공백을 넣을 수 없습니다");
        }
    }

    private boolean isBlank(String text) {
        return text == null || text.isBlank();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Result result = (Result) o;
        return Objects.equals(text, result.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(text);
    }
}
