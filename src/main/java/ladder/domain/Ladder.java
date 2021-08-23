package ladder.domain;

import ladder.exception.InvalidInputException;
import ladder.exception.LadderException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Ladder {
    private static final int LADDER_MINIMUM_HEIGHT = 2;
    private static final int GENERATE_LADDER_MAX_COUNT = 20;
    private static final String INVALID_TRY_COUNT_MESSAGE = "사다리 생성 시도 횟수를 초과했습니다. 다시 시도해주세요.";
    private static final String INVALID_HEIGHT_MESSAGE = LADDER_MINIMUM_HEIGHT + "이상의 사다리 높이를 입력해주세요";

    private List<Line> ladder;

    private Ladder(List<Line> ladder) {
        this.ladder = ladder;
    }

    public static Ladder create(int height, int countOfPerson) {
        validateLadderHeight(height);
        List<Line> ladder = new ArrayList<>();
        int tryCount = 0;
        while (validateLadder(ladder, countOfPerson)) {
            ladder.clear();
            checkTryCount(tryCount);
            ladder = generateLadder(height, countOfPerson);
            tryCount++;
        }
        return new Ladder(ladder);
    }

    private static void validateLadderHeight(int height) {
        if (height < LADDER_MINIMUM_HEIGHT) {
            throw new InvalidInputException(INVALID_HEIGHT_MESSAGE);
        }
    }

    private static boolean validateLadder(List<Line> ladder, int countOfPerson) {
        return IntStream.range(1, countOfPerson)
                        .anyMatch(i -> ladder.stream()
                                             .noneMatch(line -> line.getPoints().get(i)));
    }

    private static List<Line> generateLadder(int height, int countOfPerson) {
        List<Line> ladder = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            ladder.add(new Line(countOfPerson));
        }
        return ladder;
    }

    private static void checkTryCount(int tryCount) {
        if (tryCount > GENERATE_LADDER_MAX_COUNT) {
            throw new LadderException(INVALID_TRY_COUNT_MESSAGE);
        }
    }

    public List<Line> getLadder() {
        return Collections.unmodifiableList(ladder);
    }
}
