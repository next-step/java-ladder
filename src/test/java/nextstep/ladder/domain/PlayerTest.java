package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class PlayerTest {

    private Player player = Player.newInstance("abcde", 0);

    @DisplayName("사용자를 생성할 수 있다.")
    @Test
    void canCreatePlayer() {
        assertThat(this.player).isInstanceOf(Player.class);
    }

    @DisplayName("사용자의 이름을 얻을 수 있다.")
    @Test
    void canGetPlayerName() {
        assertThat(this.player.getName()).isInstanceOf(PlayerName.class);
    }

    @DisplayName("사용자의 위치를 얻을 수 있다.")
    @Test
    void canGetPosition() {
        assertThat(this.player.getPosition()).isInstanceOf(Position.class);
    }

    @DisplayName("사용자 이름 일치 여부를 알 수 있다.")
    @ParameterizedTest
    @MethodSource("generatePlayerName")
    void canMatchName(PlayerName playerName, boolean result) {
        assertThat(this.player.isMatchName(playerName)).isEqualTo(result);
    }

    static Stream<Arguments> generatePlayerName() {
        return Stream.of(
                Arguments.of(PlayerName.newInstance("abcde"), true),
                Arguments.of(PlayerName.newInstance("abc"), false)
        );
    }
}
