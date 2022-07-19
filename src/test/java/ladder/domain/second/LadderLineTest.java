package ladder.domain.second;

import ladder.domain.SequentialConnectionStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class LadderLineTest {
    @DisplayName("사다리 세로선 사이 가로선을 항상 번갈아가며 생성한다. (인덱스 기준 짝수 생성, 홀수 미생성)")
    @ParameterizedTest
    @ValueSource(ints = 5)
    void connect_LadderLine(int lines) {
        LadderLine ladderLine = new LadderLine(lines, new SequentialConnectionStrategy());
        List<Boolean> ladderLines = ladderLine.getConnectingLines();

        assertAll(
                () -> assertThat(ladderLines.get(0)).isTrue(),
                () -> assertThat(ladderLines.get(1)).isFalse(),
                () -> assertThat(ladderLines.get(2)).isTrue(),
                () -> assertThat(ladderLines.get(3)).isFalse(),
                () -> assertThat(ladderLines.get(4)).isTrue()
        );
    }
}