package ladder.domain;

import ladder.exception.InvalidInputException;
import ladder.exception.LadderException;
import ladder.strategy.PointStrategy;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    private static final int LADDER_MINIMUM_HEIGHT = 2;
    private static final String INVALID_HEIGHT_MESSAGE = LADDER_MINIMUM_HEIGHT + "이상의 사다리 높이를 입력해주세요";

    private static List<LadderLine> lines;

    public Ladder(List<LadderLine> lines) {
        this.lines = lines;
    }

    public static Ladder create(int height, int countOfPerson) {
        validateLadderHeight(height);
        lines = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            lines.add(LadderLine.init(countOfPerson));
        }
        return new Ladder(lines);
    }

    private static void validateLadderHeight(int height) {
        if (height < LADDER_MINIMUM_HEIGHT) {
            throw new InvalidInputException(INVALID_HEIGHT_MESSAGE);
        }
    }

    public LadderLine line(int index) {
        return lines.get(index);
    }

    public int size() {
        return lines.size();
    }

    public Map<Name, String> calculateLadderResult(Users users, WinningItems winningItems) {
        Map<Name, String> result = new HashMap<>();
        for (int i = 0; i < users.getNames().size(); i++) {
            int position = i;
            for (int j = 0; j < lines.size(); j++) {
                position = lines.get(j).move(position);
            }
            result.put(users.get(i), winningItems.get(position));
        }
        return result;
    }

}
