package nextstep.ladder.domain;

public class ConnectionCreator {

    private final ConnectionCreationStrategy connectionCreationStrategy;
    private boolean isCreated = false;

    public ConnectionCreator(ConnectionCreationStrategy connectionCreationStrategy) {
        this.connectionCreationStrategy = connectionCreationStrategy;
    }

    Connection create(int point) {
        if (!isCreated && connectionCreationStrategy.isAble()) {
            isCreated = true;
            return new Connection(point);
        }

        isCreated = false;
        return null;
    }
}
