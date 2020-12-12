package ladder.domain;

import ladder.dto.LadderDTO;
import ladder.ladderexceptions.InvalidLadderHeightException;

import java.util.*;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class Ladder {

    private static final int MINIMUM_LADDER_HEIGHT = 1;

    private List<HorizontalLine> layer;
    private List<Line> layer1;

    public Ladder(int height, int numLines) {
        validateHeight(height);
        this.layer = IntStream.range(0, height)
                .mapToObj(x -> HorizontalLine.ofLineCounts(numLines))
                .collect(toList());
    }

    public Ladder(int height, int numLines, ConnectionMode mode) {
        validateHeight(height);
        this.layer1 = IntStream.range(0, height)
                .mapToObj(x -> Line.ofLineCounts(numLines, mode))
                .collect(toList());
    }

    private void validateHeight(int height) {
        if (height < MINIMUM_LADDER_HEIGHT) {
            throw new InvalidLadderHeightException();
        }
    }

    public Ladder(List<?> lines) {
        if (lines.get(0) instanceof HorizontalLine) {
            this.layer = (List<HorizontalLine>) lines;
        }
        if (lines.get(0) instanceof Line) {
            this.layer1 = (List<Line>) lines;
        }
    }

    public void shuffle() {
        HowToConnect connectionMode = new RandomConnectionMode();
        shuffle(connectionMode);
    }

    public void shuffle(HowToConnect connectionMode) {
        for (HorizontalLine line : layer) {
            line.shuffle(connectionMode);
        }
    }

    public Users generateResult(Users users) {
        Users currentStatus = users;
        for (SwapRule rule : layer) {
            currentStatus = currentStatus.passLayer(rule);
        }
        return currentStatus;
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
        for (Line line : layer1) {
            currentIndex = line.getNextIndex(currentIndex);
        }
        return currentIndex;
    }

    public LadderDTO exportData() {
        return new LadderDTO(Collections.unmodifiableList(layer));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ladder ladder = (Ladder) o;
        return Objects.equals(layer, ladder.layer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(layer);
    }
}
