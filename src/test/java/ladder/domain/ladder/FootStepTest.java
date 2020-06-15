package ladder.domain.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class FootStepTest {
    @ParameterizedTest(name = "input = {0}")
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("디딤대는 사람 수 만큼 생성된다.")
    void make_footStep(int countOfUser) {
        FootStep footStep = new FootStep(countOfUser);
        assertThat(footStep.getSteps().size()).isEqualTo(countOfUser - 1);
    }
}