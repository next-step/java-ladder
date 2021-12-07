package nextstep.laddergame.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import nextstep.laddergame.utils.RandomUtils;

public class Line {

    private static final int BOOLEAN_LIMIT = 2;

    private final List<Bridge> bridges = new ArrayList<>();

    public Line(int countOfPerson) {
        bridges.add(makeRandomBridge());
        IntStream.range(1, countOfPerson - 1)
                 .forEach(index -> addBridge(index, bridges));
    }

    private void addBridge(int index, List<Bridge> bridges) {
        if (mustEmpty(index)) {
            bridges.add(Bridge.empty());
            return;
        }
        bridges.add(makeRandomBridge());
    }

    private Bridge makeRandomBridge() {
        return new Bridge(RandomUtils.generate(BOOLEAN_LIMIT));
    }

    private boolean mustEmpty(int index) {
        return bridges.get(index - 1).exist();
    }

    public List<Bridge> getBridges() {
        return bridges;
    }
}
