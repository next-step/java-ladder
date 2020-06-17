package ladder.domain.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class FootStepTest {
    @ParameterizedTest(name = "input = {0}")
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("디딤대는 사람 수 만큼 생성된다.")
    void make_footStep(int countOfUser) {
        FootStep footStep = new FootStep(countOfUser);
        assertThat(footStep.getSteps().size()).isEqualTo(countOfUser - 1);
    }

    @ParameterizedTest(name = "input = {0}")
    @ValueSource(ints = 0)
    @DisplayName("FootStep 생성 시 countOfUser은 0 이상이어야 한다.")
    void validate_countOfUser(int countOfUser) {
        assertThatThrownBy(() -> new FootStep(countOfUser))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("FootStep을 생성할 수 없습니다.");
    }
}