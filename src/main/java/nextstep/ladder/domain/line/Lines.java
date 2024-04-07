package nextstep.ladder.domain.line;

import java.util.List;
import java.util.stream.Collectors;
import nextstep.ladder.error.exception.LadderHeightSizeException;
import nextstep.ladder.error.exception.LinesSizeException;

public class Lines {

    private final List<Line> lines;

    public Lines(int height, List<LadderConnectOrder> randomLadderConnectOrders) {
        this(toLines(height, randomLadderConnectOrders));
    }

    public Lines(List<Line> lines) {
        this.lines = lines;
    }

    private static List<Line> toLines(int height, List<LadderConnectOrder> randomLadderConnectOrders) {
        if (height < 1) {
            throw new LadderHeightSizeException(height);
        }

        if (height != randomLadderConnectOrders.size()){
            throw new LinesSizeException(height, randomLadderConnectOrders.size());
        }

        return randomLadderConnectOrders.stream()
            .map(Line::new)
            .collect(Collectors.toList());
    }

    public int findUserResultIndex(int userIndex) {
        return lines.stream()
            .reduce(userIndex, this::adjustUserIndex, Integer::sum);
    }

    private int adjustUserIndex(int currentIndex, Line line) {
        MoveDirection direction = MoveDirection.NO_MOVE;
        if (line.canMoveRight(currentIndex)) {
            direction = MoveDirection.RIGHT;
        }

        if (!line.canMoveRight(currentIndex) && line.canMoveLeft(currentIndex)) {
            direction = MoveDirection.LEFT;
        }

        return direction.move(currentIndex);
    }

    public List<Line> getLines() {
        return lines;
    }

    public int size() {
        return lines.size();
    }
}
