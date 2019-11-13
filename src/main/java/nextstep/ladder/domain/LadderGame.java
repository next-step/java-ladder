package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class LadderGame {
    private static final int FIRST_LADDER_INDEX = 0;

    private Ladders ladders;

    public LadderGame(int size, int height) {
        List<Ladder> ladders = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            ladders.add(new Ladder());
        }
        this.ladders = new Ladders(ladders);
        init(height);
    }

    private void init(int height) {
        for (int i = 0; i < height; i++) {
            initHeight(i);
        }
    }

    private void initHeight(int height) {
        for (int i = 0; i < ladders.size(); i++) {
            Direction direction = Direction.getRandomDirection(previousLadderDirection(i, height));
            ladders.addHeight(i, direction);
        }
    }

    private Optional<Direction> previousLadderDirection(int index, int height) {
        if (index == FIRST_LADDER_INDEX) {
            return Optional.empty();
        }

        return Optional.of(ladderDirection(index - 1, height));
    }

    public Direction ladderDirection(int index, int height) {
        return ladders.ladderDirection(index, height);
    }

    public int size() {
        return ladders.size();
    }

    public int height() {
        return ladders.height();
    }
}
