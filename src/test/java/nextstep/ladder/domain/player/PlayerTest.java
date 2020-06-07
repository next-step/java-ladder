package nextstep.ladder.domain.player;

import nextstep.ladder.domain.Position;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PlayerTest {

    private Player createPlayer(String playerName, int linePosition) {
        return new Player(playerName, linePosition);
    }

    @ParameterizedTest
    @MethodSource("providePlayerNames")
    @DisplayName("player 생성 테스트")
    void createPlayerTest(String name) {
        Player player = this.createPlayer(name, 0);
        assertThat(player.getName()).isEqualTo(name);
    }

    private static Stream<Arguments> providePlayerNames() {
        return Stream.of(
                Arguments.of("test"),
                Arguments.of("iljun"),
                Arguments.of("line")
        );
    }

    @Test
    @DisplayName("name이 5자 이상일 경우 Exception")
    void validateNameBiggerThan5() {
        assertThatThrownBy(() -> this.createPlayer("ladder", 0))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("name이 null일 경우 Exception")
    void validateNullString() {
        assertThatThrownBy(() -> this.createPlayer(null, 0))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("name이 비어있을 경우 Exception")
    void validateEmptyString() {
        assertThatThrownBy(() -> this.createPlayer("", 0))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("player가 움직였을때 높이 변환 테스트")
    void movePlayerHeightPositionTest() {
        Player player = this.createPlayer("iljun", 0);
        Position beforeLineHeight = player.getCurrentHeightPosition();
        player.move(new Position(0));
        Position afterLineHeight = player.getCurrentHeightPosition();
        assertThat(beforeLineHeight.getPosition()).isEqualTo(afterLineHeight.getPosition() - 1);
    }
}
