package ladder.structure;

import ladder.structure.connection.Connections;
import ladder.structure.connection.DefaultConnection;
import ladder.structure.connection.result.Point;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class LinesTest {
    private DefaultConnection connectionStrategy = new DefaultConnection();
    private Lines lines = new Lines(5, 4, connectionStrategy);
    private List<Point> points = lines.getFinalPoints().getPoints();

    @Test
    @DisplayName("lines 생성 테스트")
    void constructorTest() {
        assertAll(
                () -> assertThat(lines.getByIndex(0).getConnections())
                        .isEqualTo(new Connections(4, connectionStrategy).getConnections()),
                () -> assertThat(lines.getByIndex(1).getConnections())
                        .isEqualTo(new Connections(4, connectionStrategy).getConnections()),
                () -> assertThat(lines.getByIndex(2).getConnections())
                        .isEqualTo(new Connections(4, connectionStrategy).getConnections()),
                () -> assertThat(lines.getByIndex(3).getConnections())
                        .isEqualTo(new Connections(4, connectionStrategy).getConnections())
        );
    }

    @ParameterizedTest
    @CsvSource(value = {
            "0:0",
            "1:1",
            "2:2",
            "3:3"
    }, delimiter = ':')
    @DisplayName("결과값 확인")
    void getFinalPoints(int start, int result) {
        assertThat(points.get(start).value()).isEqualTo(result);
    }
}