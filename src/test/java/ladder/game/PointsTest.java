package ladder.game;

import ladder.structure.connection.Connections;
import ladder.structure.connection.DefaultConnection;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PointsTest {
    @Test
    @DisplayName("point이동 경로 확인")
    void getPointsTest() {
        List<Integer> points = null;
        Connections connections = new Connections(2, new DefaultConnection());

        Points participantPoints = new Points(connections, 2, points);
        points = participantPoints.getPoints();
        assertThat(points).containsExactly(1, 0, 2);

        connections = new Connections(2, new DefaultConnection());
        participantPoints = new Points(connections, 2, points);
        points = participantPoints.getPoints();
        assertThat(points).containsExactly(0, 1, 2);
    }
}