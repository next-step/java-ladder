package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PlayerTest {

    private Player createPlayer(String playerName, int assignBridgeIndex) {
        return new Player(playerName, assignBridgeIndex);
    }

    @ParameterizedTest
    @MethodSource("providePlayerNames")
    @DisplayName("player 생성 테스트")
    void createPlayerTest(String name, int assignBridgeIndex) {
        Player player = this.createPlayer(name, assignBridgeIndex);
        assertThat(player.getName()).isEqualTo(name);
    }

    private static Stream<Arguments> providePlayerNames() {
        return Stream.of(
                Arguments.of("test", 1),
                Arguments.of("iljun", 1),
                Arguments.of("line", 1)
        );
    }

    @Test
    @DisplayName("name이 5자 이상일 경우 Exception")
    void validateNameBiggerThan5() {
        assertThatThrownBy(() -> this.createPlayer("ladder", 1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("name이 null일 경우 Exception")
    void validateNullString() {
        assertThatThrownBy(() -> this.createPlayer(null, 1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("name이 비어있을 경우 Exception")
    void validateEmptyString() {
        assertThatThrownBy(() -> this.createPlayer("", 1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("유저가 배정된 index가 음수일 경우 Exception")
    void validateNegativeNumberIndex() {
        assertThatThrownBy(() -> this.createPlayerTest("iljun", -1))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
