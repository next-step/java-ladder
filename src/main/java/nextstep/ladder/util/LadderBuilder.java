package nextstep.ladder.util;

import nextstep.ladder.domain.Bridges;
import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.wrapper.Height;
import nextstep.ladder.domain.wrapper.Width;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderBuilder {

    private static final Random RANDOM;

    static {
        RANDOM = new Random();
    }

    public static Ladder buildLadder(Width width, Height height) {
        return new Ladder(IntStream.range(0, height.value())
            .mapToObj(i -> buildBridges(width.value()))
            .collect(Collectors.toUnmodifiableList()));
    }

    private static Bridges buildBridges(int width) {
        List<Boolean> bridges = initFirstBridge();

        IntStream.range(1, width)
            .forEach(current -> createByWhetherPreviousExists(bridges, current - 1));

        return new Bridges(bridges);
    }

    private static List<Boolean> initFirstBridge() {
        List<Boolean> bridges = new ArrayList<>();
        bridges.add(createBridgeRandomly());

        return bridges;
    }

    private static void createByWhetherPreviousExists(List<Boolean> bridges, int previous) {
        if (existPreviousBridge(bridges.get(previous))) {
            bridges.add(false);
            return;
        }

        bridges.add(createBridgeRandomly());
    }

    private static boolean existPreviousBridge(boolean previousBridge) {
        return previousBridge;
    }

    private static boolean createBridgeRandomly() {
        return RANDOM.nextBoolean();
    }
}
