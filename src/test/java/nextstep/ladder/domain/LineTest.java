package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {

    @ParameterizedTest
    @ValueSource(booleans = {true, false})
    @DisplayName("라인 생성 테스트")
    void createLineTest(boolean input) {
        Line line = new Line(input);

        assertThat(line.hasLine())
                .isEqualTo(input);
    }

}
