package ladder.model;

import utils.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    private final static int LADDER_MIN_LIMIT = 0;
    private final static int LINE_ITEM_VARIABLE = 1;

    private final static String LADDER_SIZE_ERROR_MESSAGE = "올바른 사다리 높이를 입력해주세요";

    private final static Random RANDOM = new Random();

    private final List<Line> lines;

    private Ladder(List<Line> lines) {
        this.lines = lines;
    }

    public static Ladder of(String ladderSize, int userSize){
        validateLadderSize(ladderSize);

        int numberOfItems = userSize - LINE_ITEM_VARIABLE;

        List<Line> lines = IntStream.range(0, StringUtils.stringToInt(ladderSize))
                .mapToObj(x -> makeLineItems(numberOfItems))
                .map(Line::from)
                .collect(Collectors.toList());

        return new Ladder(lines);
    }
    private static List<LadderItem> makeLineItems(int numberOfItems) {
        List<LadderItem> ladderItems = new ArrayList<>();
        ladderItems.add(LadderItem.findItem(getZeroOrOne()));

        IntStream.range(1, numberOfItems)
                .forEach(idx -> ladderItems.add(makeLineItem(ladderItems.get(idx - 1))));

        return ladderItems;

    }

    private static LadderItem makeLineItem(LadderItem previousItem) {
        if (previousItem.equals(LadderItem.HORIZONTAL)) {
            return LadderItem.BLANK_HORIZONTAL;
        }

        return LadderItem.findItem(getZeroOrOne());
    }

    private static int getZeroOrOne() {
        return RANDOM.nextDouble() >= 0.5 ? 1 : 0;
    }

    private static void validateLadderSize(String size) {
        if (!StringUtils.isPositiveNumber(size)) {
            throw new IllegalArgumentException(LADDER_SIZE_ERROR_MESSAGE);
        }

        int ladderSize = StringUtils.stringToInt(size);

        if(ladderSize <= LADDER_MIN_LIMIT){
            throw new IllegalArgumentException(LADDER_SIZE_ERROR_MESSAGE);
        }
    }

    public List<String> getLadder() {
        return lines.stream()
                .map(Line::toString)
                .collect(Collectors.toList());
    }
}
