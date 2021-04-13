package nextstep.ladder.domain;

import nextstep.ladder.strategy.ConnectStrategy;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AllPointsForLines {
    private final ConnectStrategy connectStrategy;

    public AllPointsForLines(ConnectStrategy connectStrategy) {
        this.connectStrategy = connectStrategy;
    }

    public List<Points> allPoints(int countOfPlayer, int height) {
        return allPoints(new CountOfPlayer(countOfPlayer), new Height(height));
    }

    public List<Points> allPoints(CountOfPlayer countOfPlayer, Height height) {
        List<Points> allPoints = IntStream.range(0, height.value())
                .mapToObj((i) -> new Points(countOfPlayer, connectStrategy))
                .collect(Collectors.toList());

        return Collections.unmodifiableList(allPoints);
    }
}
