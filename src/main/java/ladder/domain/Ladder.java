package ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ladder {
    private static final RandomLineGenerator randomLineGenerator = new RandomLineGenerator();
    private final List<Line> lines;

    public Ladder(List<Line> lines) {
        this.lines = lines;
    }

    public static Ladder generateLadder(int ladderHeight, int countOfPerson) {
        checkLadderHeight(ladderHeight);

        List<Line> lineList = Stream.generate(() -> Line.generateLine(countOfPerson, randomLineGenerator))
                .limit(ladderHeight)
                .collect(Collectors.toList());

        return new Ladder(lineList);
    }

    private static void checkLadderHeight(int ladderHeight) {
        if (ladderHeight <= 0) {
            throw new IllegalArgumentException("사다리의 높이는 1 이상이어야 합니다.");
        }
    }

    public List<Line> getLines() {
        return lines;
    }

    public Position arrival(Position currentPosition) {
        return move(currentPosition);
    }

    private Position move(Position currentPosition) {
        if (currentPosition.getHeight() == lines.size()) {
            return currentPosition;
        }

        if (isMovable(currentPosition.getHeight(), currentPosition.getWidth() - 1)) {
            return move(currentPosition.moveLeftAndDown());
        }

        if (isMovable(currentPosition.getHeight(), currentPosition.getWidth())) {
            return move(currentPosition.moveRightAndDown());
        }

        return move(currentPosition.moveDown());
    }

    private boolean isMovable(int height, int width) {
        if (height < 0 || height >= lines.size()) {
            return false;
        }

        if (width < 0 || width >= lines.get(0).getBridge().size()) {
            return false;
        }

        return lines.get(height).getBridge().get(width);
    }

}
