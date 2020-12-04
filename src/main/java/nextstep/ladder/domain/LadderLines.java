package nextstep.ladder.domain;

import java.util.List;
import java.util.function.Consumer;

public interface LadderLines {
    int MINIMUM_SIZE = 2;
    int MINIMUM_HEIGHT = 1;

    int move(int index);

    void forEach(Consumer<List<Boolean>> singleLineConsumer);

    default void ensure(int size, int height) {
        if (size < MINIMUM_SIZE || height < MINIMUM_HEIGHT) {
            throw new IllegalStateException();
        }
    }
}
