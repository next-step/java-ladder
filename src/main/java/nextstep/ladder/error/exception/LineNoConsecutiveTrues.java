package nextstep.ladder.error.exception;

import java.text.MessageFormat;

public class LineNoConsecutiveTrues extends RuntimeException {

    public LineNoConsecutiveTrues() {
        super(MessageFormat.format("{0}", "Line은 연속해서 사다리를 연결할 수 없습니다"));
    }
}
