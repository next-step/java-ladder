package ladder.structure;

import ladder.structure.connection.DefaultMove;
import ladder.structure.connection.MoveStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LinesTest {
    private MoveStrategy moveStrategy = new DefaultMove();
    private Lines lines = new Lines(5, 5, moveStrategy);
    private List<Integer> finalPoints = lines.getFinalPoints();

    @ParameterizedTest
    @CsvSource(value = {"0:1", "1:0", "2:3", "3:2", "4:4"}, delimiter = ':')
    @DisplayName("결과값 확인")
    void getFinalPoints(int start, int result) {
        assertThat(finalPoints.get(start)).isEqualTo(result);
    }
}