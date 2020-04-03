package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class StepTest {
    @DisplayName("가로 라인 생성")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5})
    void createStep(int position) {
        Step step = Step.of(position, () -> false);

        assertThat(step.getPosition()).isEqualTo(position);
    }
}
