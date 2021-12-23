package ladder.domain;

import ladder.strategy.MovingStrategy;

import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

public class Floor {
    private final Connections connections;
    private final MovingStrategy movingStrategy;

    public Floor(int countOfPillar, MovingStrategy movingStrategy) {
        this.movingStrategy = movingStrategy;
        this.connections = new Connections();
        IntStream.range(0, countOfPillar).forEach(this::line);
    }

    private void line(int i) {
        // 앞에 선이 있었으면 추가 불가(무조건 false), 없었다면 랜덤하게 추가
        if (i == 0 || connections.connected(i - 1)) {
            connections.addLine(false);
            return;
        }
        connections.addLine(movingStrategy.canMove());
    }

    public List<Connection> getConnections() {
        return this.connections.getConnections();
    }

    // 왼쪽: -1 오른쪽 : + 1
    public int whichDirection(int position) {
        // position == 0 인 경우는 없음 section은 1부터
        int nextPosition = position;
        if (connections.connected(position - 1)) {
            nextPosition -= 1;
        }
        if (position != connections.size() && connections.connected(position)) {
            nextPosition += 1;
        }
        return nextPosition;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Floor floor = (Floor) o;
        return Objects.equals(connections, floor.connections);
    }

    @Override
    public int hashCode() {
        return Objects.hash(connections);
    }
}
