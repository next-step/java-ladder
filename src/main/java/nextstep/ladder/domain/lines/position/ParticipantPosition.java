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
        while (isLessThanMaxHeight(maxHeight) && !findLeftPoint(lines)) {
            moveMiddleWay();
        }
        if (isLessThanMaxHeight(maxHeight)) {
            return moveLeftSide();
        }
        return new ParticipantPosition(lines.size(), maxHeight);
    }

    private boolean findLeftPoint(List<Line> lines) {
        Point leftPoint = lines.get(this.position.calculateMinusPosition()).horizontalLine(this.height.getValue());
        return leftPoint.movable();
    }

    private boolean isLessThanMaxHeight(int maxHeight) {
        return this.height.isLessThan(maxHeight);
    }

    private ParticipantPosition moveLeftSide() {
        return new ParticipantPosition(this.position.leftPosition(), this.height.higherHeight());
    }

    private void moveMiddleWay() {
        this.height = this.height.higherHeight();
    }

    public Position startAtNormalLine(List<Line> lines) {
        int maxHeight = lines.get(0).getMaxHeight();
        while (this.height.isLessThan(maxHeight)) {
            this.position = checkDirection(lines).move(this.position);
            moveMiddleWay();
        }
        return this.position;
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
