package ladder.domain.model;

import ladder.domain.model.strategy.CheckConnectStrategy;
import ladder.domain.model.strategy.ConnectionStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class Line {
    private static final Random RANDOM = new Random();
    private static final int RANGE_START = 0;
    private static final int ZERO = 0;

    private List<Boolean> points = new ArrayList<>();

    void calculatorLine(int countOfPerson) {
        int rangeEnd = countOfPerson - 1;

        IntStream.range(RANGE_START, rangeEnd)
                .forEach(count -> {
                    if (count == ZERO || !points.get(count - 1)) {
                        connectLine(() -> RANDOM.nextBoolean());
                        return;
                    }
                    connectLine(() -> false);
                });
    }

    public Player getConnectNumber(Player player, CheckConnectStrategy checkConnectStrategy) {
        int result = player.getResult();

        if (isResultPullRight(result)) {
            player.move(result + checkConnectStrategy.getLeftConnectResult(player, points));
            return player;
        }

        if (isResultPullLeft(result)) {
            player.move(result + checkConnectStrategy.getRightConnectResult(player, points));
            return player;
        }

        player.move(result + checkConnectStrategy.getConnectResult(player, points));
        return player;
    }

    boolean isResultPullRight(int result) {
        return result >= points.size();
    }

    boolean isResultPullLeft(int result) {
        return result <= 0;
    }

    public List<Boolean> getLine() {
        return points;
    }

    public void connectLine(ConnectionStrategy connectionStrategy) {
        if (connectionStrategy.isConnection()) {
            points.add(true);
            return;
        }
        points.add(false);
    }

    @Override
    public String toString() {
        return "Line{" +
                "points=" + points +
                '}';
    }
}
