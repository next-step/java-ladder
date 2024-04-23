package ladder.domain.ladder.line;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import ladder.domain.ladder.Width;

public class LineTest {

    public static final ConnectionGenerator testConnectionGenerator = new ConnectionGenerator() {
        @Override
        public Connection generateFirst() {
            return Connection.first(true);
        }

        @Override
        public Connection generateNext(Connection previousConnection) {
            return previousConnection.next(!previousConnection.isRightConnected());
        }
    };

    public static Line line(boolean... isConnected) {
        final List<Connection> connections = new ArrayList<>() {{
            add(Connection.first(isConnected[0]));
        }};

        IntStream.range(1, isConnected.length)
                .mapToObj(i -> connections.get(i - 1).next(isConnected[i]))
                .forEach(connections::add);

        connections.add(connections.get(connections.size() - 1).last());

        return new Line(connections);
    }

    @Test
    @DisplayName("사다리 너비를 기준으로 사다리의 라인을 생성한다.")
    void Line_PlayersCount() {
        final Line expectedLine = line(true, false, true, false);

        final Line actualLine = Line.of(new Width(5), testConnectionGenerator);

        assertThat(actualLine).isEqualTo(expectedLine);
    }

    @Test
    @DisplayName("라인 연결 상태에 따라 포지션을 이동한다.")
    void Move_Positions() {
        final Line line = line(true, false, true, false);
        final Map<Integer, Integer> initialRoute = new HashMap<>() {{
            put(0, 0);
            put(1, 1);
            put(2, 2);
            put(3, 3);
        }};
        final Map<Integer, Integer> expectedRoute = Map.of(
                0, 1,
                1, 0,
                2, 3,
                3, 2
        );

        assertThat(line.move(initialRoute))
                .isEqualTo(expectedRoute);
    }
}
