package nextstep.ladder.domain;

public class LineFactory {
    private static final int ZERO = 0;
    private final ConnectionsFactory connectionsFactory;

    public LineFactory(ConnectionsFactory connectionsFactory) {
        this.connectionsFactory = connectionsFactory;
    }

    public Line create(int numberOfConnections) {
        validateNumberOfConnections(numberOfConnections);
        return new Line(connections(numberOfConnections));
    }

    private Connections connections(int numberOfConnections) {
        return connectionsFactory.create(numberOfConnections);
    }

    private void validateNumberOfConnections(int numberOfConnections) {
        if(numberOfConnections < ZERO) {
            throw new IllegalArgumentException("라인 연결수는 0 미만이 될 수 없습니다: " + numberOfConnections);
        }
    }
}
