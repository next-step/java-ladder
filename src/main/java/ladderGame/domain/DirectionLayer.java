package ladderGame.domain;

import ladderGame.util.DirectionGenerator;

import java.util.List;
import java.util.stream.IntStream;

public class DirectionLayer {

    private final static int EXCEPT_NUMBER = 1;
    private List<Direction> directions;

    private DirectionLayer(List<Direction> directions) {
        verifyOutOfLadderDirection(directions);
        verifyLadderRule(directions);
        this.directions = directions;
    }

    public static DirectionLayer ofGenerator(int numberOfPlayer, DirectionGenerator directionGenerator) {
        List<Direction> directions = directionGenerator.generate(getNumberOfRungs(numberOfPlayer));
        verifyQuantity(numberOfPlayer, directions);
        return new DirectionLayer(directions);
    }

    private static void verifyQuantity(int numberOfPlayer, List<Direction> directions) {
        if (numberOfPlayer != directions.size()) {
            throw new IllegalArgumentException("방향의 수는 입력된 참가자와 동일해야 합니다.");
        }
    }

    private static int getNumberOfRungs(int numberOfPlayers) {
        return numberOfPlayers - EXCEPT_NUMBER;
    }

    public List<Direction> getDirectionsByPosition() {
        return directions;
    }

    public Direction getDirectionsByPosition(Position position) {
        return IntStream.range(0, directions.size())
                .filter(position::isEquals)
                .mapToObj(index -> directions.get(index))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 범위의 Position 입니다." + position.toString()));
    }

    private void verifyLadderRule(List<Direction> directions) {
        directions.stream()
                .reduce(null, this::verifyRule);
    }

    private Direction verifyRule(Direction previous, Direction current) {
        if ((previous == Direction.RIGHT && current != Direction.LEFT)
                || (previous == Direction.LEFT && current == Direction.LEFT)
                || (previous == Direction.STRAIGHT && current == Direction.LEFT)) {
            throw new IllegalArgumentException("게임 룰에 맞지 않는 방향이 있습니다.");
        }
        return current;
    }

    private void verifyOutOfLadderDirection(List<Direction> directions) {
        Direction firstDirection = directions.get(0);
        Direction lastDirection = directions.get(directions.size() - 1);

        if (firstDirection == Direction.LEFT || lastDirection == Direction.RIGHT) {
            throw new IllegalArgumentException("사다리 범위를 넘어가는 움직임");
        }
    }
}
