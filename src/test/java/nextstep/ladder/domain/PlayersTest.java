package nextstep.ladder.domain;

import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class PlayersTest {

    @Test
    @DisplayName("중복된 이름 입력")
    public void duplicatedName() {
        // given
        String names = "1,2,1,4";
        String message = "중복된 참가자 이름은 존재할 수 없습니다";

        // when
        ThrowingCallable throwingCallable = () -> new Players(names);

        // then
        assertThatThrownBy(throwingCallable)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(message);
    }

    @ParameterizedTest(name = "플레이어 count 테스트 | {arguments}")
    @CsvSource(value = {"pobi,honux,crong,jk|4", "a|1"}, delimiter = '|')
    public void count(final String names, final int expected) {
        // given

        // when
        Players players = new Players(names);

        // then
        assertThat(players).isNotNull();
        assertThat(players.count()).isEqualTo(expected);
    }

    @Test
    @DisplayName("getPositions 테스트 - 없는 이름")
    public void getPositionsNonExistentName() {
        // given
        Players players = new Players("pobi,honux,crong,jk");
        WonderingPlayers wonderingPlayers = new WonderingPlayers(players, "a");
        String message = String.format("존재하지 않는 참가자 이름입니다 -> %s", "a");

        // when
        ThrowingCallable throwingCallable = () -> players.getPositions(wonderingPlayers);

        // then
        assertThatThrownBy(throwingCallable)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(message);
    }

    @Test
    @DisplayName("getPositions 테스트 - all")
    public void getPositionsAll() {
        // given
        Players players = new Players("pobi,honux,crong,jk");
        WonderingPlayers wonderingPlayers = new WonderingPlayers(players, "all");

        // when
        List<Integer> positions = players.getPositions(wonderingPlayers);

        // then
        assertThat(positions).containsExactly(0, 1, 2, 3);
    }

    @Test
    @DisplayName("getPositions 테스트")
    public void getPositions() {
        // given
        Players players = new Players("pobi,honux,crong,jk");
        WonderingPlayers wonderingPlayers = new WonderingPlayers(players, "honux");

        // when
        List<Integer> positions = players.getPositions(wonderingPlayers);

        // then
        assertThat(positions).containsExactly(1);
    }

}