package nextstep.step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import step3.domain.game.Game;
import step3.domain.game.GameData;
import step3.domain.ladder.Ladder;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class GameTest {
    @ParameterizedTest
    @DisplayName("LadderLine 생성 성공")
    @MethodSource("createLadder")
    public void createGame(List<String> names, int size) {
        //given
        GameData gameData = GameData.of(names, size);

        //when, then
        Ladder ladder = Game.createLadder(gameData);
    }

    @ParameterizedTest
    @DisplayName("LadderLine 생성 성공")
    @MethodSource("createLadderFail")
    public void createGameFail(List<String> names, int size) {
        //given, when, then
        assertThatThrownBy(() -> {
            GameData gameData = GameData.of(names, size);
        }).isInstanceOf(RuntimeException.class);
    }

    static Stream<Arguments> createLadder() {
        return Stream.of(
            Arguments.arguments(Arrays.asList("a", "b", "c"), 5),
            Arguments.arguments(Arrays.asList("a", "b", "c", "d", "e"), 5)
        );
    }

    static Stream<Arguments> createLadderFail() {
        return Stream.of(
            Arguments.arguments(Arrays.asList(), 5),
            Arguments.arguments(Arrays.asList("abcdefghj"), 5),
            Arguments.arguments(Arrays.asList("a", "b", "c", "d", "e"), -1)
        );
    }
}
