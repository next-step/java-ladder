package laddergame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNoException;

class LadderGameRewardTest {

    @DisplayName("사다리 게임 결과가 정상적으로 들어오면 에러가 발생하지 않아야 한다.")
    @ParameterizedTest
    @ValueSource(strings = {
            "a",
            "ab",
            "abc",
            "abcd",
            "abcde",
    })
    void create(String name) {
        assertThatNoException()
                .isThrownBy(() -> new LadderGameReward(name));
    }

    @DisplayName("사다리 게임 결과는 null이거나 공백이면 에러가 발생해야 한다.")
    @ParameterizedTest
    @NullAndEmptySource
    void create_givenNullOrEmpty(String name) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LadderGameReward(name));
    }

    @DisplayName("사다리 게임 결과가 5자를 넘어가면 에러가 발생해야 한다.")
    @Test
    void create_givenNameOverMaxLength() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LadderGameReward("abcdef"));
    }

}
