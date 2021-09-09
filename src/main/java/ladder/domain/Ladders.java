package ladder.domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladders {
    private final List<Line> lines;

    private Ladders(final List<Line> lines) {
        this.lines = lines;
    }

    public static Ladders initLadders(final LadderWidth ladderWidth, final LadderHeight ladderHeight,
                                      final DirectionMakingStrategy directionMakingStrategy) {
        return IntStream.range(0, ladderHeight.getValue())
                .mapToObj(index -> Line.initLine(ladderWidth, directionMakingStrategy))
                .collect(Collectors.collectingAndThen(Collectors.toList(), Ladders::new));
    }

    public void play(final Players players, final PlayResults playResults) {
        validatePlayerSize(players);
        validateSameSize(players, playResults);
        for (int index = 0; index < players.size(); index++) {
            Position position = new Position(index);
            Player player = players.find(position);
            player.report(playResults.find(move(position)));
        }
    }

    private void validatePlayerSize(final Players players) {
        if (!Objects.equals(getLadderWidth(), new LadderWidth(players.size()))) {
            throw new IllegalArgumentException("플레이어 수는 사다리 개수와 동일해야합니다.");
        }
    }

    private void validateSameSize(final Players players, final PlayResults playResults) {
        if (!playResults.isSameLength(players.size())) {
            throw new IllegalArgumentException("플레이어 수와 실행 결과 수는 같아야합니다.");
        }
    }

    private Position move(final Position position) {
        Position movedPosition = position;
        for (Line line : lines) {
            movedPosition = line.move(movedPosition);
        }
        return movedPosition;
    }

    public List<Line> getLines() {
        return lines;
    }

    public LadderWidth getLadderWidth() {
        Line firstLine = lines.get(0);
        return firstLine.getLadderWidth();
    }

    public LadderHeight getLadderHeight() {
        return new LadderHeight(lines.size());
    }
}