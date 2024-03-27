package nextstep.ladder.exception;

import java.text.MessageFormat;
import java.util.List;

public class LinePointsSizeException extends IllegalArgumentException {
    public LinePointsSizeException(int expected, List<Boolean> points) {
        super(MessageFormat.format("사다리의 좌표 개수가 유효하지 않습니다. (기대 좌표 수: {0}, 입력된 좌표: {1}, 입력된 좌표 수: {2})"
                , expected, points, points.size()));
    }
}
