package ladder.domain;

import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.function.Function;

public enum LadderDirection {

    LEFT(((ladder, position) -> {
        if(ladder.onFirstColumn(position)) {
            return false;
        }
        return position.left().checkLine(ladder);
    }), (position -> position.left().down())),

    RIGHT(((ladder, position) -> {
        if(ladder.onLastColumn(position)) {
            return false;
        }
        return position.checkLine(ladder);
    }), (position -> position.right().down())),

    DOWN(((ladder, position) -> {
        if(ladder.onFirstColumn(position)) {
            return !position.checkLine(ladder);
        }
        if(ladder.onLastColumn((position))) {
            return !position.left().checkLine(ladder);
        }
        return !position.left().checkLine(ladder) &&
                !position.checkLine(ladder);
    }), (position -> position.down()));


    public static LadderDirection valueOf(Ladder ladder, Position currentPosition) {
        return Arrays.stream(LadderDirection.values())
                .filter(ladderDirection2 -> ladderDirection2.canMove.apply(ladder, currentPosition))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    LadderDirection(BiFunction<Ladder, Position, Boolean> canMove, Function<Position, Position> move) {
        this.canMove = canMove;
        this.move = move;
    }

    public BiFunction<Ladder, Position, Boolean> canMove;
    public Function<Position, Position> move;
}
