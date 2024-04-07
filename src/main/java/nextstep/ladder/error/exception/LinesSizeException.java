package nextstep.ladder.error.exception;

import java.text.MessageFormat;

public class LinesSizeException extends RuntimeException {

    public LinesSizeException(Object height, Object LadderConnectOrder) {
        super(MessageFormat.format("{0} height : {1}, LadderConnectOrderSize : {2}",
            "높이와 사다리연결 명령은 동일해야합니다",
            height,
            LadderConnectOrder));
    }
}
