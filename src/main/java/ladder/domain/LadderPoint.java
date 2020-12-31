package ladder.domain;

import ladder.util.ErrorMessage;

public class LadderPoint {

    private int index;
    private LadderDirection direction;

    public LadderPoint(final int index, final LadderDirection direction) {
        checkValue(index, direction);
        initPoint(index, direction);
        movePoint();
    }

    public static LadderPoint movePointBody(LadderPoint ladderPoint) {
        LadderDirection direction = LadderDirectionNext.makeDirectionBody(ladderPoint.getDirection());
        LadderPoint returnPoint = new LadderPoint(ladderPoint.getIndex(), direction);

        return returnPoint;
    }

    public static LadderPoint movePointLast(LadderPoint ladderPoint) {
        LadderDirection direction = LadderDirectionNext.makeDirectionLast(ladderPoint.getDirection());
        LadderPoint returnPoint = new LadderPoint(ladderPoint.getIndex(), direction);

        return returnPoint;
    }

    private void initPoint(final int index, final LadderDirection direction) {
        this.index = index;
        this.direction = direction;
    }

    public void movePoint(int index){
        this.index = index;
    }

    private void movePoint() {
        this.index = index + this.direction.moveDistance();
    }

    private void checkValue(final int index, final LadderDirection direction) {
        checkIndex(index);
        checkNull(direction);
    }

    private void checkIndex(final int index) {
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