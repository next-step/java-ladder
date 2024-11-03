package nextstep.ladder.domain;

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
}
