package cc.oakk.ladder.model.ladder;

import cc.oakk.ladder.model.size.LadderWidth;
import cc.oakk.ladder.util.RandomUtils;

import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static cc.oakk.ladder.util.ArrayUtils.toPrimitiveArray;
import static cc.oakk.ladder.util.ValidationUtils.throwIfNull;

public class LadderInitializer {
    private final LadderWidth width;
    private final BiFunction<Integer, Integer, boolean[]> connectionsProvider;

    public LadderInitializer(int width, BiFunction<Integer, Integer, boolean[]> connectionsProvider) {
        this.width = new LadderWidth(width);
        this.connectionsProvider = throwIfNull(connectionsProvider);
    }

    public static LadderInitializer random(int ladderWidth) {
        return new LadderInitializer(ladderWidth, (width, height) -> {
            int oddOrEven = RandomUtils.nextInt(2);
            return toPrimitiveArray(IntStream.range(0, ladderWidth - 1)
                    .boxed()
                    .map(i -> i % 2 == oddOrEven && RandomUtils.nextBoolean())
                    .collect(Collectors.toList()));
        });
    }

    public boolean[] provideConnections(int heightIndex) {
        boolean[] connections = connectionsProvider.apply(width.get(), heightIndex);
        if (connections.length != width.get() - 1) {
            throw new RuntimeException("제공하는 연결 상태의 개수는 사다리 너비 - 1개여야합니다.");
        }
        return connections;
    }
}
