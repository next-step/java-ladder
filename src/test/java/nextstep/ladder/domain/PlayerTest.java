package nextstep.ladder.domain;

import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class PlayerTest {

    @ParameterizedTest(name = "플레이어 생성 - 1~5글자가 아닌 경우 | {arguments}")
    @ValueSource(strings = {"abcdef", ""})
    public void validLength(String name) {
        // given
        String message = String.format("입력값은 공백을 제외한 1~5글자 여야 합니다 -> %s", name);

        // when
        ThrowingCallable throwingCallable = () -> new Player(name);

        // then
        assertThatThrownBy(throwingCallable)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(message);
    }

    @ParameterizedTest(name = "플레이어 생성 - 1~5글자인 경우 | {arguments}")
    @ValueSource(strings = {"a", "abcde"})
    public void createPlayer(String name) {
        // given

        // when
        Player player = new Player(name);

        // then
        assertThat(player).isNotNull();
    }

}