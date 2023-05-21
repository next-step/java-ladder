package nextstep.ladder.domain;

import nextstep.ladder.domain.strategy.BridgeStrategy;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ladder implements Iterable<Line>{

    private final List<Line> ladder;
    private final Map<String, String> gameResult;

    public static Ladder of(Participants participants, Height height, BridgeStrategy strategy) {
        return new Ladder(participants, height, strategy);
    }

    private Ladder(Participants participants, Height height, BridgeStrategy strategy) {
        this.ladder = create(participants,height, strategy);
        this.gameResult = new LinkedHashMap<>();
    }

    public List<Line> create(Participants participants, Height height, BridgeStrategy strategy) {
        return Stream.generate(() -> new Line(participants.number(), strategy))
                .limit(height.getHeight())
                .collect(Collectors.toList());
    }

    int size() {
        return ladder.size();
    }

    @Override
    public Iterator<Line> iterator() {
        return ladder.iterator();
    }

    public Map<String, String> generateResult(Participants participants, LadderResult result) {
        participants.forEach(name -> {
            int index = calculateIndexOfResult(participants, name);
            gameResult.put(name, result.get(index));
        });
        return gameResult;
    }
    private int calculateIndexOfResult(Participants participants, String name) {
        int index = participants.indexOf(name);
        int maxIndex = participants.maxIndex();

        for (Line line : ladder) {
            index = calculateIndex(index, maxIndex, line);
        }
        return index;
    }

    private int calculateIndex(int index, int maxIndex, Line line) {
        if (checkIndexLine(index, maxIndex, line)) {
            index++;
            return index;
        }
        if (checkPreviousIndexLine(index, line)) {
            index--;
        }
        return index;
    }

    private static boolean checkIndexLine(int index, int maxIndex, Line line) {
        return index != maxIndex && line.get(index);
    }

    private static boolean checkPreviousIndexLine(int index, Line line) {
        return index - 1 >= 0 && line.get(index - 1);
    }
}
