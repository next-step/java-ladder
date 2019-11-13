package nextstep.ladder.domain;

import java.util.List;
import java.util.Optional;

public class Ladders {
    private static final int FIRST_LADDER_INDEX = 0;

    private List<Ladder> ladders;

    public Ladders(List<Ladder> ladders) {
        this.ladders = ladders;
    }

    public Ladders(List<Ladder> ladders, int height) {
        this.ladders = ladders;
        init(height);
    }

    private void init(int height) {
        for (int i = 0; i < height; i++) {
            initHeight(i);
        }
    }

    private void initHeight(int height) {
        for (int i = 0; i < ladders.size(); i++) {
            addHeight(i, height);
        }
    }

    public int size() {
        return ladders.size();
    }

    public void addHeight(int index, int height) {
        Optional<Direction> previousLadderDirection = previousLadderDirection(index, height);
        Direction direction = Direction.getRandomDirection(previousLadderDirection);
        ladders.get(index).addHeight(direction);
    }

    public int height() {
        return ladders.stream()
                .map(Ladder::height)
                .max(Integer::compareTo)
                .orElse(0);
    }

    public Direction ladderDirection(int index, int height) {
        return ladders.get(index).getDirectionOfHeight(height);
    }

    public Optional<Direction> previousLadderDirection(int index, int height) {
        if (index == FIRST_LADDER_INDEX) {
            return Optional.empty();
        }

        return Optional.of(ladderDirection(index - 1, height));
    }
}
