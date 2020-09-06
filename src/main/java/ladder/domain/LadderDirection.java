package ladder.domain;

import java.util.Arrays;

public enum LadderDirection {

    LEFT{
        @Override
        public boolean canMove(Ladder ladder, Position currentPosition) {
            if(ladder.onFirstColumn(currentPosition)) {
                return false;
            }
            return currentPosition.left().checkLine(ladder);
        }

        @Override
        public Position move(Position position) {
            return position.left().down();
        }
    },
    RIGHT{
        @Override
        public boolean canMove(Ladder ladder, Position currentPosition) {
            if(ladder.onLastColumn(currentPosition)){
                return false;
            }
            return currentPosition.checkLine(ladder);
        }

        @Override
        public Position move(Position position) {
            return position.right().down();
        }
    },
    DOWN{
        @Override
        public boolean canMove(Ladder ladder, Position currentPosition) {
            if(ladder.onFirstColumn(currentPosition)) {
                return !currentPosition.checkLine(ladder);
            }
            if(ladder.onLastColumn((currentPosition))) {
                return !currentPosition.left().checkLine(ladder);
            }
            return !currentPosition.left().checkLine(ladder) &&
                    !currentPosition.checkLine(ladder);
        }

        @Override
        public Position move(Position position) {
            return position.down();
        }
    };

    public static LadderDirection valueOf(Ladder ladder, Position currentPosition) {
        return Arrays.stream(LadderDirection.values())
                .filter(direction -> direction.canMove(ladder, currentPosition))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    public boolean canMove(Ladder ladder, Position currentPosition) {
        return false;
    }

    public Position move(Position position) {
        return position;
    }
}
