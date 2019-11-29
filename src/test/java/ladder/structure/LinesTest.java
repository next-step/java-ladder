package ladder.structure;

import ladder.structure.connection.ConnectionStrategy;
import ladder.structure.connection.DefaultConnection;
import ladder.structure.connection.result.Point;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LinesTest {
    private ConnectionStrategy connectionStrategy = new DefaultConnection();
    private Lines lines = new Lines(5, 5, connectionStrategy);
    private List<Point> points = lines.getFinalPoints(new DefaultConnection()).getPoints();

//    @Test
//    @DisplayName("lines 생성 테스트")
//    void constructorTest() {
//        List<LineOfLadder> lineList = lines.getLines();
//        assertAll(
//                () -> assertThat(lineList.get(0).getConnections())
//                        .isEqualTo(new Points(4, connectionStrategy).getConnections()),
//                () -> assertThat(lineList.get(2).getConnections())
//                        .isEqualTo(new Points(4, connectionStrategy).getConnections()),
//                () -> assertThat(lineList.get(4).getConnections())
//                        .isEqualTo(new Points(4, connectionStrategy).getConnections())
//        );
//    }

    @ParameterizedTest
    @CsvSource(value = {"0:1", "1:0", "2:3", "3:2", "4:4"}, delimiter = ':')
    @DisplayName("결과값 확인")
    void getFinalPoints(int start, int result) {
        assertThat(points.get(start).value()).isEqualTo(result);
    }
}