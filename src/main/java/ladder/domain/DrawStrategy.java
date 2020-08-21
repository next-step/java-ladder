package ladder.domain;

import java.util.function.Consumer;

public interface DrawStrategy {
    void draw(int index, Consumer<Integer> indexConsumer);
}
