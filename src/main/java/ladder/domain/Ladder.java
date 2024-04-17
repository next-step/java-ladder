package ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ladder implements LadderStrategy{
    private static final RandomLineGenerator randomLineGenerator = new RandomLineGenerator();
    private final List<LineStrategy> lines;

    public Ladder(List<LineStrategy> lines) {
        this.lines = lines;
    }

    public static Ladder generateLadder(int ladderHeight, int countOfPerson) {
        checkLadderHeight(ladderHeight);

        List<LineStrategy> lineList = Stream.generate(() -> Line.generateLine(countOfPerson, randomLineGenerator))
                .limit(ladderHeight)
                .collect(Collectors.toList());

        return new Ladder(lineList);
    }

    private static void checkLadderHeight(int ladderHeight) {
        if (ladderHeight <= 0) {
            throw new IllegalArgumentException("사다리의 높이는 1 이상이어야 합니다.");
        }
    }

    @Override
    public List<LineStrategy> getLines() {
        return lines;
    }

    @Override
    public Position arrival(Position initialPosition) {
        return Stream.iterate(initialPosition, this::nextPosition)
                .filter(position -> position.isArrivalPosition(lines.size()))
                .findFirst()
                .orElse(initialPosition);
    }

    private Position nextPosition(Position currentPosition) {
        if (isMovable(currentPosition.getHeight(), currentPosition.getWidth() - 1)) {
            return currentPosition.moveLeftAndDown();
        }

        if (isMovable(currentPosition.getHeight(), currentPosition.getWidth())) {
            return currentPosition.moveRightAndDown();
        }

        return currentPosition.moveDown();
    }

    private boolean isMovable(int height, int width) {
        if (height < 0 || height >= lines.size()) {
            return false;
        }

        if (width < 0 || width >= lines.get(0).countOfBridge()) {
            return false;
        }

        return lines.get(height).canMove(width);
    }

}
