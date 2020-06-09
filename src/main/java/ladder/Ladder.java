package ladder;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {

    private final Players players;
    private final List<LadderLine> ladderLines;

    public Ladder(Players players, LadderHeight ladderHeight) {
        Objects.requireNonNull(players, "players는 null일 수 없습니다.");
        Objects.requireNonNull(ladderHeight, "ladderHeight은 null일 수 없습니다.");

        this.players = players;
        this.ladderLines = drawLines(ladderHeight);
    }

    private List<LadderLine> drawLines(LadderHeight ladderHeight) {
        int playersCount = players.size();
        RandomDrawingPointsStrategy drawingPointsStrategy = new RandomDrawingPointsStrategy();

        return IntStream.range(0, ladderHeight.getHeight())
                .mapToObj(i -> new LadderLine(playersCount, drawingPointsStrategy))
                .collect(Collectors.toList());
    }

    public List<LadderLine> getLadderLines() {
        return Collections.unmodifiableList(ladderLines);
    }
}
