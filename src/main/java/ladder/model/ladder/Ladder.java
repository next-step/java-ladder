package ladder.model.ladder;

import utils.StringUtils;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    private final static int LADDER_MIN_LIMIT = 0;
    private final static String LADDER_SIZE_ERROR_MESSAGE = "올바른 사다리 높이를 입력해주세요";
    private final static String RESULT_SIZE_ERROR = "시작지점과 사람 수가 일치하지 않습니다.";

    private final List<Line> lines;

    private Ladder(List<Line> lines) {
        this.lines = lines;
    }

    public static Ladder of(String ladderSize, int userSize) {
        validateLadderSize(ladderSize);

        List<Line> lines = IntStream.range(0, StringUtils.stringToInt(ladderSize))
                .mapToObj(idx -> Line.from(userSize))
                .collect(Collectors.toList());

        return new Ladder(lines);
    }

    public Map<String, Integer> getResults(List<String> userNames) {
        validateUserNames(userNames);

        return IntStream.range(0, userNames.size())
                .boxed()
                .collect(Collectors.toMap(userNames::get, this::getResultIndex));
    }

    private void validateUserNames(List<String> userNames){
        boolean validation = lines.stream()
                .map(line -> line.size() == userNames.size())
                .reduce((x,y) -> x && y).orElse(false);

        if(!validation){
            throw new IllegalArgumentException(RESULT_SIZE_ERROR);
        }
    }

    private int getResultIndex(int start){
        return lines.stream()
                .reduce(start, (idx, line) -> line.move(idx), (x, y) -> y);
    }

    private static void validateLadderSize(String size) {
        if (!StringUtils.isPositiveNumber(size)) {
            throw new IllegalArgumentException(LADDER_SIZE_ERROR_MESSAGE);
        }

        int ladderSize = StringUtils.stringToInt(size);

        if (ladderSize <= LADDER_MIN_LIMIT) {
            throw new IllegalArgumentException(LADDER_SIZE_ERROR_MESSAGE);
        }
    }

    public List<String> getLadder() {
        return lines.stream()
                .map(Line::toString)
                .collect(Collectors.toList());
    }
}