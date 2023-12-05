package nextstep.ladder.domain.lines.position;

import java.util.List;
import java.util.Objects;
import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.Point;
import nextstep.ladder.domain.lines.Direction;

public class ParticipantPosition {
    private Position position;
    private Height height;

    public ParticipantPosition(Position position, Height height) {
        this.position = position;
        this.height = height;
    }

    public ParticipantPosition(Position position) {
        this(position, new Height(0));
    }

    public ParticipantPosition(int position, int height) {
        this.position = new Position(position);
        this.height = new Height(height);
    }

    public boolean isLastLine(int size) {
        return this.position.isSame(size);
    }

    public ParticipantPosition startAtLastLine(List<Line> lines) {
        int maxHeight = lines.get(0).getMaxHeight();
        ParticipantPosition movedPosition = getMovedPosition(lines, maxHeight);
        if (movedPosition == this) {
            return new ParticipantPosition(lines.size(), maxHeight);
        }
        return movedPosition;
    }

    private ParticipantPosition getMovedPosition(List<Line> lines, int maxHeight) {
        while (hasNotReachedMaxHeight(maxHeight) && !findLeftPoint(lines)) {
            moveMiddleWay();
        }
        if (hasNotReachedMaxHeight(maxHeight)) {
            return moveLeftSide();
        }
        return this;
    }

    private boolean hasNotReachedMaxHeight(int maxHeight) {
        return this.height.isLessThan(maxHeight);
    }

    private void moveMiddleWay() {
        this.height = this.height.higherHeight();
    }

    private boolean findLeftPoint(List<Line> lines) {
        Point leftPoint = lines.get(this.position.calculateMinusPosition()).horizontalLine(this.height.getValue());
        return leftPoint.movable();
    }

    private ParticipantPosition moveLeftSide() {
        return new ParticipantPosition(this.position.leftPosition(), this.height.higherHeight());
    }

    public Position startAtNormalLine(List<Line> lines) {
        int maxHeight = lines.get(0).getMaxHeight();
        while (shouldContinueMoving(maxHeight)) {
            moveInLadder(lines, maxHeight);
        }
        return this.position;
    }

    private boolean shouldContinueMoving(int maxHeight) {
        return this.height.isLessThan(maxHeight);
    }

    private void moveInLadder(List<Line> lines, int maxHeight) {
        if (offTheLadder(lines)) {
            moveReverse(lines, maxHeight);
            return;
        }
        moveInDirection(lines);
        moveMiddleWay();
    }

    private boolean offTheLadder(List<Line> lines) {
        return lines.size() == this.position.getValue();
    }

    private void moveReverse(List<Line> lines, int maxHeight) {
        ParticipantPosition participantPosition = getMovedPosition(lines, maxHeight);
        this.position = participantPosition.position;
        this.height = participantPosition.height;
    }

    private void moveInDirection(List<Line> lines) {
        this.position = checkDirection(lines).move(this.position);
    }

    private Direction checkDirection(List<Line> lines) {
        Line currentLine = lines.get(this.position.getValue());
        if (currentLine.ableToMoveSideWay(this.height.getValue())) {
            return Direction.RIGHT;
        }

        int beforePosition = this.position.getBeforePosition();
        Point leftPoint = lines.get(beforePosition).horizontalLine(this.height.getValue());
        if (leftPoint.movable()) {
            return Direction.LEFT;
        }

        return Direction.MIDDLE;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ParticipantPosition that = (ParticipantPosition) o;
        return Objects.equals(position, that.position) && Objects.equals(height, that.height);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, height);
    }
}
