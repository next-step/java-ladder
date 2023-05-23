package nextstep.ladder.domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderGame {
    private final UserNames userNames;
    private final List<Line> lines;

    private final Map<String, Integer> gameResult;

    private LadderGame(LadderHeight ladderHeight, UserNames userNames) {
        this.userNames = userNames;
        lines = IntStream.range(0, ladderHeight.getHeight())
                .mapToObj(i -> drawLine(userNames.count()))
                .collect(Collectors.toList());

        gameResult = new HashMap<>();
    }

    private Line drawLine(int ladderWidth) {
        return Line.of(ladderWidth);
    }

    public static LadderGame create(LadderHeight ladderHeight, UserNames userNames) {
        return new LadderGame(ladderHeight, userNames);
    }

    public List<Line> toList() {
        return Collections.unmodifiableList(lines);
    }

}
