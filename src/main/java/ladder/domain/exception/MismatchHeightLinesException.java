package ladder.domain.exception;

public class MismatchHeightLinesException extends RuntimeException {

    public MismatchHeightLinesException() {
        super("높이와 라인수가 일치하지 않습니다.");
    }
}
