package nextstep.ladder.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public final class Ladder {
    private static final int MIN_HEIGHT = 1;

    private final List<LadderLine> ladderLines;

    private Ladder(List<LadderLine> ladders) {
        this.ladderLines = new ArrayList<>(ladders);
    }

    public static Ladder initate(int userSize, int height) {
        validate(height);
        return new Ladder(ladderLines(userSize, height));
    }

    public List<LadderLine> getLadderLines() {
        return Collections.unmodifiableList(ladderLines);
    }

    public int move(int index) {
        for (LadderLine ladderLine : ladderLines) {
            index = ladderLine.move(index);
        }
        return index;
    }

    public int height() {
        return ladderLines.size();
    }

    private static void validate(int height) {
        if (height < MIN_HEIGHT) {
            throw new IllegalArgumentException(String.format("전달된 사다리의 높이(%d)는 %d이상이 필요합니다.", height, MIN_HEIGHT));
        }
    }

    private static List<LadderLine> ladderLines(int userSize, int height) {
        return IntStream.range(0, height)
                .mapToObj(x -> LadderLine.init(userSize))
                .collect(Collectors.toList());
    }
}
