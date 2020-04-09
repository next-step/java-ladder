package ladder.model;

import java.util.List;

public class LadderMoveDirections {
    private final List<LadderMoveDirection> ladderMoveDirections;

    private LadderMoveDirections(final List<LadderMoveDirection> ladderMoveDirections) {
        this.ladderMoveDirections = ladderMoveDirections;
    }

    public static LadderMoveDirections newInstance(final List<LadderMoveDirection> ladderMoveDirections) {
        return new LadderMoveDirections(ladderMoveDirections);
    }
}
