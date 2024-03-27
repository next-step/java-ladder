package nextstep.ladder.exception;

import java.text.MessageFormat;
import java.util.List;

public class LineConsecutivePointException extends IllegalArgumentException {
    public LineConsecutivePointException(List<Boolean> points) {
        super(MessageFormat.format("하나의 라인에 연속적인 좌표는 가질 수 없습니다. (입력된 좌표: {0})", points));
    }
}
