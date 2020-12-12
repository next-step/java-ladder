package ladder.domain;

import ladder.dto.LadderDTO;
import ladder.ladderexceptions.InvalidLadderHeightException;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class Ladder {

    private static final int MINIMUM_LADDER_HEIGHT = 1;

    private final List<Line> layer;

    public Ladder(int height, int numLines, ConnectionMode mode) {
        validateHeight(height);
        this.layer = IntStream.range(0, height)
                .mapToObj(x -> Line.ofLineCounts(numLines, mode))
                .collect(toList());
    }

    private void validateHeight(int height) {
        if (height < MINIMUM_LADDER_HEIGHT) {
            throw new InvalidLadderHeightException();
        }
    }

    public Ladder(List<Line> lines) {
        this.layer = lines;
    }

    public Result generateResult(Users users, Rewards rewards) {
        Map<User, Reward> mapper = new HashMap<>();
        for (int i = 0; i < users.size(); i++) {
            int resultIndex = passAllLayer(i);
            mapper.put(users.get(i), rewards.get(resultIndex));
        }
        return new Result(mapper);
    }

    private int passAllLayer(int initialIndex) {
        int currentIndex = initialIndex;
        for (Line line : layer) {
            currentIndex = line.getNextIndex(currentIndex);
        }
        return currentIndex;
    }

    public LadderDTO exportData() {
        return new LadderDTO(Collections.unmodifiableList(layer));
    }
}
