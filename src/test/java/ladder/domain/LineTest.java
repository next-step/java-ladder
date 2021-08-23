package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {

    @ParameterizedTest
    @DisplayName("Line 생성 성공 테스트")
    @ValueSource(ints = {2, 3, 4, 5})
    void 사다리_높이_입력_성공_테스트(int number) {
        Line line = new Line(number);
        assertThat(line.getPoints().size()).isEqualTo(number);
    }
}
