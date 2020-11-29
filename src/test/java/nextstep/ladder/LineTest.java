package nextstep.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {

    @Test
    @DisplayName("사다리 가로줄 담당 역할 생성")
    void createLine() {
        Line line = new Line(3);
    }

    @Test
    @DisplayName("사다리 가로줄 연결 생성")
    void createConnection() {
        Line line = new Line(3);
        Connections connections = line.createConnections(() -> true);

        Connections expectedConnections = new Connections(Arrays.asList(new Connection(0), new Connection(2)));
        assertThat(connections).isEqualTo(expectedConnections);
    }
}
