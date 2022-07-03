package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class HorizontalLinesTest {
    @DisplayName("사다리 세로선 사이 가로선을 항상 번갈아가며 생성한다. (인덱스 기준 짝수 생성, 홀수 미생성)")
    @ParameterizedTest
    @ValueSource(ints = 5)
    void connect(int lines) {
        HorizontalLines horizontalLines = new HorizontalLines(lines, new SequentialConnectionStrategy());
        List<Boolean> horizontalLineList = horizontalLines.getConnectingLines();

        assertAll(
            () -> assertThat(horizontalLineList.get(0)).isTrue(),
            () -> assertThat(horizontalLineList.get(1)).isFalse(),
            () -> assertThat(horizontalLineList.get(2)).isTrue(),
            () -> assertThat(horizontalLineList.get(3)).isFalse(),
            () -> assertThat(horizontalLineList.get(4)).isTrue()
        );
    }
}
