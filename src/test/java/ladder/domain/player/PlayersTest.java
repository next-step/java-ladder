package ladder.domain.player;

import ladder.exception.NeedMorePlayerException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PlayersTest {

    @ParameterizedTest
    @ValueSource(strings = {"kim", "pobi"})
    @DisplayName("플레이어가 한명이면 게임진행이 불가하기때문에 예외를 던진다")
    public void NeedMorePlayerExceptionTest(String players) {
        Assertions.assertThrows(NeedMorePlayerException.class , () ->
                new Players(players)
        );
    }
}