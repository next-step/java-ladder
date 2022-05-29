package ladder.domain.player;

import ladder.exception.NeedMorePlayerException;
import ladder.exception.NotFoundPlayerException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class PlayersTest {

    @ParameterizedTest
    @ValueSource(strings = {"kim", "pobi"})
    @DisplayName("플레이어가 한명이면 게임진행이 불가하기때문에 예외를 던진다")
    public void NeedMorePlayerExceptionTest(String players) {
        Assertions.assertThrows(NeedMorePlayerException.class , () ->
                new Players(players)
        );
    }


    private static Stream<Arguments> playerArgs() {
        return Stream.of(
                arguments("a,b,c,d", "e"),
                arguments("pobi,honux,crong,jk", "kim"),
                arguments("pobi,honux,crong,jk", "")
        );
    }

    @ParameterizedTest
    @MethodSource("playerArgs")
    @DisplayName("결과를 보고싶은 플레이어가 없으면 예외를 던진다.")
    public void NotFoundPlayerException(String players, String inputPlayer) {
        Assertions.assertThrows(NotFoundPlayerException.class, () ->
                new Players(players).getPositionInLadder(inputPlayer)
        );
    }

    private static Stream<Arguments> playerPositionTestArgs() {
        return Stream.of(
                arguments(new Players("a,b,c,d"), "a", 0),
                arguments(new Players("pobi,honux,crong,jk"), "jk", 3),
                arguments(new Players("pobi,honux,crong,jk"), "honux", 1),
                arguments(new Players("pobi,honux,crong,jk"), "all", -1)
        );
    }

    @ParameterizedTest
    @MethodSource("playerPositionTestArgs")
    @DisplayName("입력한 플레이어는 플레이어 리스트중에서 몇번쨰에 위치하는지 테스트한다.")
    public void PlayerPositionLadderTest(Players players, String inputPlayer, int position) {
        assertThat(players.getPositionInLadder(inputPlayer)).isEqualTo(position);
    }
}