package ladder.domain;

import java.util.function.Consumer;

@FunctionalInterface
public interface LadderPointGenerator {
    void generate(int lineSize, int maxConnectCount, Consumer<Integer> connectLine);
}
