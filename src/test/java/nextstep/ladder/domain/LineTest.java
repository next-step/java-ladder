package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {

    @Test
    @DisplayName("사다리 가로줄 연결 생성")
    void createLine() {
        Line line = new Line(3, () -> true);

        Connections expectedConnections = new Connections(Arrays.asList(new Connection(true), new Connection(false), new Connection(true)));
        assertThat(line.getConnections()).isEqualTo(expectedConnections);
    }
}
