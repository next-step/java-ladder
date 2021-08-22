package ladder.domain;

import ladder.exception.LadderException;
import ladder.strategy.PointStrategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Ladder {
    private static final String INVALID_TRY_COUNT_MESSAGE = "사다리 생성 시도 횟수를 초과했습니다. 다시 시도해주세요.";

    private List<Line> ladder;

    private Ladder(List<Line> ladder) {
        this.ladder = ladder;
    }

    public static Ladder of(int height, int countOfPerson) {
        List<Line> ladder = new ArrayList<>();
        int tryCount = 0;
        while (!valid(ladder, height)) {
            ladder.clear();
            checkTryCount(tryCount);
            ladder = generateLadder(height, countOfPerson);
            tryCount++;
        }

        return new Ladder(ladder);
    }

    private static List<Line> generateLadder(int height, int countOfPerson) {
        List<Line> ladder = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            ladder.add(new Line(countOfPerson));
        }
        return ladder;
    }

    private static boolean valid(List<Line> ladder, int height) {
        boolean valid = true;
        ladder.stream().forEach(line -> line.getPoints().stream().anyMatch(point -> point));
        for (int i = 0; i < ladder.get(i).getPoints().size(); i++) {
            for (int j = 0; j < height; j++) {
                if (ladder.get(j).getPoints().get(i)) {
                    valid = false;
                }
            }
        }
        return valid;
    }

    private static void checkTryCount(int tryCount) {
        if (tryCount > 20) {
            throw new LadderException(INVALID_TRY_COUNT_MESSAGE);
        }
    }

    public List<Line> getLadder() {
        return Collections.unmodifiableList(ladder);
    }
}
