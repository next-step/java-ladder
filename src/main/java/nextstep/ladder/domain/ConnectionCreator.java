package nextstep.ladder.domain;

public class ConnectionCreator {

    private boolean isCreated = false;

    Connection create(int point, ConnectionCreationStrategy connectionCreationStrategy) {
        if (!isCreated && connectionCreationStrategy.isAble()) {
            isCreated = true;
            return new Connection(true);
        }

        isCreated = false;
        return new Connection(false);
    }
}
