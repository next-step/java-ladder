package ladder.structure;

import ladder.structure.connection.ConnectionStrategy;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class Ladder {
    private static final String LADDER_HEIGHT_EXCEPTION = "사다리게임의 높이는 0 이상입니다.";
    private List<LineOfLadder> ladder;

    public Ladder(int personCount, int ladderHeight, ConnectionStrategy connectionStrategy) {
        verityLadderHeight(ladderHeight);
        this.ladder = new ArrayList<>();
        for (int i = 0; i < ladderHeight; i++) {
            this.ladder.add(new LineOfLadder(personCount - 1, connectionStrategy));
        }
    }

    private void verityLadderHeight(int ladderHeight) {
        if (ladderHeight <= 0) {
            throw new IllegalArgumentException(LADDER_HEIGHT_EXCEPTION);
        }
    }

    public List<List<Boolean>> getConnectedLine() {
        return ladder.stream()
                .map(LineOfLadder::getConnections)
                .collect(toList());
    }

    public List<List<Integer>> findPointsByLine() {
        List<List<Integer>> results = new ArrayList<>();
        List<Integer> points = null;
        for (int line = 0; line < ladder.size(); line++) {
            points = ladder.get(line).findNextPoints(points);
            results.add(points);
        }
        return results;
    }

    public List<Integer> findFinalPoints() {
        List<List<Integer>> results = findPointsByLine();
        return results.get(results.size() - 1);
    }

}
