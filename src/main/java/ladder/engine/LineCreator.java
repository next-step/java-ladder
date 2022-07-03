package ladder.engine;

import ladder.domain.ConnectingStrategy;

import java.util.List;

public interface LineCreator {
    void connect(ConnectingStrategy connectingStrategy);

    List<Boolean> getConnectingLines();
}