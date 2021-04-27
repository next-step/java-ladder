package step4.domain;

import step4.exception.IllegalPositionRangeException;

public class Position {
    private int position;

    public Position(int position) {
        positionRangeValidate(position);
        this.position = position;
    }

    private void positionRangeValidate(int position) {
        if (position < 0) {
            throw new IllegalPositionRangeException("position이 음수가 될수 없습니다.");
        }
    }

    public Position move(int movePosition) {
        //updatePosition(movePosition);

        return new Position(movePosition);
    }

//    private void updatePosition(int movePosition) {
//        position = movePosition;
//    }

    public int getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Position)) return false;

        Position position1 = (Position) o;

        return position == position1.position;
    }

    @Override
    public int hashCode() {
        return position;
    }
}
