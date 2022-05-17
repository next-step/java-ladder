package nextstep.ladder.domain.exceptions;

public class NotAllowNegativeOrZero extends IllegalArgumentException {
    public NotAllowNegativeOrZero() {
        super("음수이거나 0은 허용되지 않은 값입니다.");
    }
}
