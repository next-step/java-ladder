package nextstep.ladder;

public class StringLengthException extends IllegalArgumentException {
    private static final int LETTER_LIMIT = 5;

    public StringLengthException() {
        super(String.format("이름은 %d글자 이상 넣을 수 없습니다.", LETTER_LIMIT));
    }
}
