package nextstep.ladder.domain;

import nextstep.ladder.domain.Player;
import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class PlayerTest {

    @Test
    @DisplayName("플레이어 생성 - 플레이어 이름이 null 인 경우")
    public void nonNull() {
        // given
        String name = null;
        String message = "플레이어 이름은 null 일 수 없습니다";

        // when
        ThrowingCallable throwingCallable = () -> new Player(name);

        // then
        assertThatThrownBy(throwingCallable)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(message);
    }

    @ParameterizedTest(name = "플레이어 생성 - 플레이어 이름이 1~5글자가 아닌 경우 | {arguments}")
    @ValueSource(strings = {"abcdef", ""})
    public void validLength(String name) {
        // given
        String message = String.format("플레이어 이름은 공백을 제외한 1~5글자 여야 합니다 -> %s", name);

        // when
        ThrowingCallable throwingCallable = () -> new Player(name);

        // then
        assertThatThrownBy(throwingCallable)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(message);
    }

    @ParameterizedTest(name = "플레이어 생성 - 플레이어 이름이 1~5글자인 경우 | {arguments}")
    @ValueSource(strings = {"a", "abcde"})
    public void createPlayer(String name) {
        // given

        // when
        Player player = new Player(name);

        // then
        assertThat(player).isNotNull();
    }

}