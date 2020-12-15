package ladder.domain;

import ladder.util.ErrorMessage;

public class LadderPoint {

    private int index;
    private LadderDirection direction;

    public LadderPoint(final int index, final LadderDirection direction) {
        checkValue(index, direction);
        initPoint(index, direction);
    }

    private void initPoint(final int index, final LadderDirection direction) {
        this.index = index;
        this.direction = direction;
    }

    public void move(){
        this.index = index+ direction.move();
    }

    public int getMoveIndex(){
        return direction.move();
    }

    private void checkValue(final int index, final LadderDirection direction) {
        checkIndex(index);
        checkNull(direction);
    }

    private void checkIndex(int index) {
        if (index < 0) {
            throw new RuntimeException(ErrorMessage.getCheckPointIndex());
        }
    }

    private void checkNull(final LadderDirection direction) {
        if (direction == null) {
            throw new RuntimeException(ErrorMessage.getCheckNullDirection());
        }
    }

    public LadderDirection getDirection() {
        return direction;
    }

    public int getIndex() {
        return index;
    }

}