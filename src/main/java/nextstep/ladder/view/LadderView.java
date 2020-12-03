package nextstep.ladder.view;

import java.util.List;
import java.util.function.Consumer;

public interface LadderView {
    List<String> getGoals();

    void forEachLine(Consumer<List<Boolean>> singleLineConsumer);
}
