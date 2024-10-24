package step2.util;

import step2.model.Line;

public class LadderDirection {

    // 라인 좌우를 체크하며 방향을 정한다.
    public static int decideDirection(Line line, int i) {
        if (i >= 0 && line.getLineTrueOrFalse(i)) {
            return i - 1;
        }
        if (i < line.pointSize() - 1 && line.getLineTrueOrFalse(i + 1)) {
            return i + 1;
        }
        return i;
    }

}
