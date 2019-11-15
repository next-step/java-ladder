package ladder.structure;

import ladder.structure.connection.ConnectionStrategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class Ladder {
    private static final String LADDER_HEIGHT_EXCEPTION = "사다리게임의 높이는 0 이상입니다.";
    private List<LineOfLadder> ladder;
    private List<Integer> finalPoints;

    public Ladder(int personCount, int ladderHeight, ConnectionStrategy connectionStrategy) {
        verityLadderHeight(ladderHeight);
        addLine(personCount, ladderHeight, connectionStrategy);
    }

    private void addLine(int personCount, int ladderHeight, ConnectionStrategy connectionStrategy) {
        List<LineOfLadder> lines = new ArrayList<>();
        List<Integer> points = null;
        for (int i = 0; i < ladderHeight; i++) {
            LineOfLadder line = new LineOfLadder(personCount - 1, connectionStrategy, points);
            lines.add(line);
            points = line.getPointsAfterConnection();
        }
        this.ladder = lines;
        this.finalPoints = points;
    }

    public List<List<Boolean>> getConnectedLine() {
        return ladder.stream()
                .map(LineOfLadder::getConnections)
                .collect(toList());
    }

    public List<Integer> getFinalPoints() {
        return Collections.unmodifiableList(finalPoints);
    }

    private void verityLadderHeight(int ladderHeight) {
        if (ladderHeight <= 0) {
            throw new IllegalArgumentException(LADDER_HEIGHT_EXCEPTION);
        }
    }

    public List<LineOfLadder> getLadder() {
        return Collections.unmodifiableList(ladder);
    }
}
