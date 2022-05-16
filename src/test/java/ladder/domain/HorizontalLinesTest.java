package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class HorizontalLinesTest {
    @DisplayName("사다리 세로선 사이 가로선을 생성한다.")
    @ParameterizedTest
    @ValueSource(ints = 5)
    void connect(int lines) {
        HorizontalLines horizontalLines = new HorizontalLines();
        List<Boolean> connect = horizontalLines.connect(lines);
        assertThat(connect).hasSize(lines);
    }
}
