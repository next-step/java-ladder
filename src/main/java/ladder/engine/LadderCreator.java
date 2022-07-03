package ladder.engine;

import ladder.domain.ConnectingStrategy;

import java.util.List;

public interface LadderCreator {
    void create(ConnectingStrategy connectingStrategy);

    List<? extends LineCreator> getLines();
}