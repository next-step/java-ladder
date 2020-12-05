package ladder.model;

import utils.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    private final static int LADDER_MIN_LIMIT = 0;
    private final static int LINE_ITEM_VARIABLE = 1;

    private final static String LADDER_SIZE_ERROR_MESSAGE = "올바른 사다리 높이를 입력해주세요";

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
    private static List<Bridge> makeLineItems(int numberOfItems) {
        List<Bridge> bridges = new ArrayList<>();
        bridges.add(Bridge.createRandomBridge(0));

        IntStream.range(1, numberOfItems)
                .forEach(idx -> bridges.add(makeBridge(idx, bridges.get(idx-1))));

        return bridges;

    }
    private static Bridge makeBridge(int idx, Bridge previousBridges){
        if(previousBridges.isMovable()){
            return Bridge.createNonMovableBridge(idx);
        }

        return Bridge.createRandomBridge(idx);
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
