package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class HorizontalLinesTest {

    @DisplayName("사다리 세로선 사이 가로선을 항상 번갈아가며 생성한다. (인덱스 기준 짝수 생성, 홀수 미생성)")
    @ParameterizedTest
    @ValueSource(ints = 5)
    void connect(int lines) {
        HorizontalLines horizontalLines = new HorizontalLines();
        ConnectingStrategy connectingStrategy = new SequentialConnectionStratrgy();
        horizontalLines.connect(lines, connectingStrategy);

        List<Boolean> horizontalLineList = horizontalLines.getHorizontalLines();
        for (int i = 0; i < horizontalLineList.size(); i++) {
            if (i % 2 == 0) {
                assertThat(horizontalLineList.get(i)).isTrue();
                continue;
            }
            assertThat(horizontalLineList.get(i)).isFalse();
        }
    }
}
