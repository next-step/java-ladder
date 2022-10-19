package laddergame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNoException;

class RewardTest {
    @Test
    @DisplayName("사람 이름이 5글자가 넘는 경우 IllegalArgumentException")
    void name_length_when_greater_than_5() {
        //given
        String input = "abcdef";
        //then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Reward(input));
    }

    @Test
    @DisplayName("보상이 5글자 이하인 경우 정상")
    void name_length_when_less_than_5() {
        //given
        String input = "abcde";
        //then
        assertThatNoException()
                .isThrownBy(() -> new Reward(input));
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("사람 이름이 빈 값이면 IllegalArgumentException")
    void name_null_and_empty(String input) {
        //then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Reward(input));
    }
}