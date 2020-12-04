package nextstep.ladder.domain;

import java.util.List;
import java.util.function.Consumer;

public interface LadderLines {
    int move(int index);

    void forEach(Consumer<List<Boolean>> singleLineConsumer);
}
