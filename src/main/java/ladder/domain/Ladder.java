package ladder.domain;

import ladder.exception.InvalidInputException;
import ladder.exception.LadderException;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    private static final int LADDER_MINIMUM_HEIGHT = 2;
    private static final int GENERATE_LADDER_MAX_COUNT = 20;
    private static final String INVALID_TRY_COUNT_MESSAGE = "사다리 생성 시도 횟수를 초과했습니다. 다시 시도해주세요.";
    private static final String INVALID_HEIGHT_MESSAGE = LADDER_MINIMUM_HEIGHT + "이상의 사다리 높이를 입력해주세요";

    private List<Line> lines;

    private Ladder(List<Line> lines) {
        this.lines = lines;
    }

    public static Ladder create(int height, int countOfPerson) {
        validateLadderHeight(height);
        List<Line> lines = new ArrayList<>();
        int tryCount = 0;
        while (validateLadder(lines, countOfPerson)) {
            lines.clear();
            checkTryCount(tryCount);
            lines = generateLadder(height, countOfPerson);
            tryCount++;
        }
        return new Ladder(lines);
    }

    private static void validateLadderHeight(int height) {
        if (height < LADDER_MINIMUM_HEIGHT) {
            throw new InvalidInputException(INVALID_HEIGHT_MESSAGE);
        }
    }

    private static boolean validateLadder(List<Line> ladder, int countOfPerson) {
        return IntStream.range(1, countOfPerson)
                        .anyMatch(i -> ladder.stream()
                                             .noneMatch(line -> line.point(i)));
    }

    private static List<Line> generateLadder(int height, int countOfPerson) {
        List<Line> ladder = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            ladder.add(Line.valueOf(countOfPerson));
        }
        return ladder;
    }

    private static void checkTryCount(int tryCount) {
        if (tryCount > GENERATE_LADDER_MAX_COUNT) {
            throw new LadderException(INVALID_TRY_COUNT_MESSAGE);
        }
    }

    public String getLadderString() {
        return lines.stream()
                    .map(line -> line.generateLineString())
                    .collect(Collectors.joining("\n"));
    }

    public int size() {
        return lines.size();
    }

    public Map<Name, String> calculateLadderResult(Users users, WinningItems winningItems) {
        Map<Name, String> result = new HashMap<>();
        for (int i = 0; i < users.getNames().size(); i++) {
            Location location = new Location(i);
            lines.forEach(location::moveLocation);
            result.put(users.get(i), winningItems.get(location.getLocation()));
        }
        return result;
    }

}
