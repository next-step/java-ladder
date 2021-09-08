package nextstep.laddergame.domain;

import java.util.List;

@FunctionalInterface
public interface LineConnectStrategy {
    List<LineConnection> getLineConnections();
}
