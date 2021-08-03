package nextstep.ladder.domain.player;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class PlayerTest {
    @DisplayName("이름 String으로 player 객체를 만들 수 있다")
    @Test
    void should_make_player() {
        //arrange, act, assert
        assertThat(Player.of("name")).isInstanceOf(Player.class);
    }

    @DisplayName("플레이어 이름이 null 이거나 비어있으면 IllegalArgumentException이 발생한다")
    @NullAndEmptySource
    @ParameterizedTest
    void should_throw_exception_when_null_or_empty(String name) {
        assertThatIllegalArgumentException().isThrownBy(() -> Player.of(name));
    }

    @DisplayName("플레이어 이름이 5글자를 초과하는 경우 IllegalArgumentException이 발생한다")
    @ValueSource(strings = {"aaaaab", "aaaaabc"})
    @ParameterizedTest
    void should_throw_exception(String name) {
        assertThatIllegalArgumentException().isThrownBy(() -> Player.of(name));
    }
}