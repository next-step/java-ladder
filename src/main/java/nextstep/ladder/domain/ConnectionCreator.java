package nextstep.ladder.domain;

public class ConnectionCreator {

    private boolean isCreated;

    Connection create(int point, ConnectionCreationStrategy connectionCreationStrategy) {
        if (!isCreated && connectionCreationStrategy.isAble(point)) {
            isCreated = true;
            return Connection.connected();
        }

        isCreated = false;
        return Connection.disConnected();
    }
}
