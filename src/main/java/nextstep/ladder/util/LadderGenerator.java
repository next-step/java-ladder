package nextstep.ladder.util;

import nextstep.ladder.Ladder;
import nextstep.ladder.LadderLine;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 사다리 라인을 생성하는 유틸 모음집
 */
public class LadderGenerator {
    private LadderGenerator() {
    }

    /**
     * 주어진 컬럼 수를 가지는 사다리 라인을 랜덤으로 하나 만듭니다.
     *
     * @param theNumberOfColumn 컬럼 수
     *
     * @return 랜덤 사다리 라인
     */
    public static LadderLine generateRandomLine(int theNumberOfColumn) {
        if (theNumberOfColumn < 0) {
            throw new IllegalArgumentException("컬럼을 0개 이하로 지정할 수 없으나 " + theNumberOfColumn + "개로 지정되어 호출되었습니다.");
        }

        List<Boolean> connectionInfo = new ArrayList<>(theNumberOfColumn-1);

        for (int i = 0; i < theNumberOfColumn - 1; i++) {
            connectionInfo.add(false);
        }

        for (int i = 0; i < theNumberOfColumn - 1; i++) {
            if (i != 0 && connectionInfo.get(i-1) == true) {
                continue;
            }

            Random random = new Random();
            boolean connectFlag = random.nextBoolean();
            connectionInfo.set(i, connectFlag);
        }

        return LadderLine.of(connectionInfo);
    }

    public static Ladder generateRandomLadder(int theNumberOfColumn, int depth) {
        List<LadderLine> lines = new ArrayList<>(depth);

        for (int i = 0; i < depth; i++) {
            lines.add(generateRandomLine(theNumberOfColumn));
        }

        return Ladder.of(lines);
    }
}