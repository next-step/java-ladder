package nextstep.ladder.entity.ladder;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ladder {
    private final List<LinesOfOneHeight> linesOfOneHeightList;

    public Ladder(List<LinesOfOneHeight> lines) {
        this.linesOfOneHeightList = lines;
    }

    public Ladder(int userCount , int ladderHeight) {
        this(lines(userCount, ladderHeight));
    }

    private static List<LinesOfOneHeight> lines(int userCount, int ladderHeight) {
        return Stream.generate(() -> new LinesOfOneHeight(userCount))
                .limit(ladderHeight)
                .collect(Collectors.toList());
    }

    public int gameEndPosition(int startPosition) {

        int gameEndPosition = startPosition;

        for (LinesOfOneHeight linesOfOneHeight : linesOfOneHeightList) {
            gameEndPosition = linesOfOneHeight.nextHeightPosition(gameEndPosition);
        }

        return gameEndPosition;
    }

    public List<LinesOfOneHeight> getLines() {
        return Collections.unmodifiableList(linesOfOneHeightList);
    }

}
