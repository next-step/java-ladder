package my.project.step3.domain;

import my.project.common.domain.Reward;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

/**
 * Created : 2020-12-10 오전 8:02
 * Developer : Seo
 */
class RewardTest {

    @DisplayName("잘못 입력된 값 - 5글자 이상")
    @ParameterizedTest
    @ValueSource(strings = {"crong12345"})
    void givenInvalidValue_thenThrowException(String input) {
        assertThatThrownBy(() -> new Reward(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("포맷 확인")
    @ParameterizedTest
    @ValueSource(strings = {"cro"})
    void givenReward_thenFormatting(String input) {
        assertThat(new Reward(input).get()).isEqualTo("cro  ");
    }
}