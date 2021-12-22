package nextstep.ladder.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public final class Ladder {

    private final List<LadderLine> ladders;

    private Ladder(List<LadderLine> ladders) {
        this.ladders = new ArrayList<>(ladders);
    }

    public static Ladder initate(int userSize, int height) {
        return new Ladder(ladderLines(userSize, height));
    }

    public List<LadderLine> getLadders() {
        return Collections.unmodifiableList(ladders);
    }

    private static List<LadderLine> ladderLines(int userSize, int height) {
        return IntStream.range(0, height)
                .boxed()
                .map(x -> LadderLine.init(userSize))
                .collect(Collectors.toList());
    }
}
