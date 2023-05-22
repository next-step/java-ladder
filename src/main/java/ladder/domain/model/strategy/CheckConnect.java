package ladder.domain.model.strategy;

import ladder.domain.model.Player;

import java.util.List;

public class CheckConnect implements CheckConnectStrategy {
    public enum Direction {
        LEFT(-1),
        RIGHT(1),
        NONE(0);

        private final int value;

        Direction(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    @Override
    public int getConnectResult(Player player, List<Boolean> points) {
        int result = player.getResult();
        // 오른쪽이동
        if (points.get(result)) {
            return Direction.RIGHT.getValue();
        }
        // 왼쪽이동
        if (points.get(result - 1)) {
            return Direction.LEFT.getValue();
        }
        return Direction.NONE.getValue();
    }

    @Override
    public int getLeftConnectResult(Player player, List<Boolean> points) {
        int result = player.getResult();
        if (points.get(result - 1)) {
            return Direction.LEFT.getValue();
        }
        return Direction.NONE.getValue();
    }

    @Override
    public int getRightConnectResult(Player player, List<Boolean> points) {
        int result = player.getResult();
        if (points.get(result)) {
            return Direction.RIGHT.getValue();
        }
        return Direction.NONE.getValue();
    }


}
