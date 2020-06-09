package ladder;

import java.util.Objects;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class Ladder {

    private final Players players;
    private final LadderLines ladderLines;

    public Ladder(Players players, LadderHeight ladderHeight) {
        Objects.requireNonNull(players, "players는 null일 수 없습니다.");
        Objects.requireNonNull(ladderHeight, "ladderHeight은 null일 수 없습니다.");

        this.players = players;
        this.ladderLines = drawLines(ladderHeight);
    }

    private LadderLines drawLines(LadderHeight ladderHeight) {
        int playersCount = players.size();
        RandomDrawingPointsStrategy drawingPointsStrategy = new RandomDrawingPointsStrategy();

        return IntStream.range(0, ladderHeight.getHeight())
                .mapToObj(i -> new LadderLine(playersCount, drawingPointsStrategy))
                .collect(collectingAndThen(toList(), LadderLines::new));
    }

    public LadderLines getLadderLines() {
        return ladderLines;
    }
}
