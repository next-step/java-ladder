package nextstep.ladder.domain.lines;

import java.util.List;
import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.Point;

public class ParticipantPosition {

    private int position;
    private int height;

    public ParticipantPosition(int position, int height) {
        this.position = position;
        this.height = height;
    }

    public boolean isLastLine(int size) {
        return this.position == size;
    }

    public ParticipantPosition startAtLastLine(List<Line> lines) {
        int maxHeight = lines.get(0).getMaxHeight();
        while (isLessThanMaxHeight(maxHeight)) {
            if (findLeftPoint(lines)) {
                return moveLeftSide();
            }
            moveMiddleWay();
        }
        return new ParticipantPosition(lines.size(), maxHeight);
    }

    private boolean findLeftPoint(List<Line> lines) {
        Point leftPoint = lines.get(position - 1).horizontalLine(height);
        return leftPoint.movable();
    }

    private boolean isLessThanMaxHeight(int maxHeight) {
        return height < maxHeight;
    }

    private ParticipantPosition moveLeftSide() {
        return new ParticipantPosition(position - 1, height + 1);
    }

    private void moveMiddleWay() {
        this.height = this.height + 1;
    }

    public int startAtNormalLine(List<Line> lines) {
        int maxHeight = lines.get(0).getMaxHeight();
        while (height < maxHeight) {
            position = checkDirection(lines).move(position);
            height++;
        }
        return position;
    }

    private Direction checkDirection(List<Line> lines) {
        Line currentLine = lines.get(position);
        if (currentLine.ableToMoveSideWay(height)) {
            return Direction.RIGHT;
        }

        int beforePosition = getBeforePosition(lines.size());
        Point leftPoint = lines.get(beforePosition).horizontalLine(height);
        if (leftPoint.movable()) {
            return Direction.LEFT;
        }

        return Direction.MIDDLE;
    }

    private int getBeforePosition(int size) {
        if (position == 0 || position > size) {
            return 0;
        }
        return position - 1;
    }
}
