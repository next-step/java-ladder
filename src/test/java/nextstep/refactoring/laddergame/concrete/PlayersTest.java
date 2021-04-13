package nextstep.refactoring.laddergame.concrete;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.util.NoSuchElementException;
import nextstep.refactoring.ladder.concrete.TestLadder;
import nextstep.refactoring.ladder.engine.Ladder;
import nextstep.refactoring.ladder.engine.Position;
import nextstep.refactoring.laddergame.engine.player.Player;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlayersTest {

    static Players players() {
        return Players.of("a", "b", "c", "d", "e");
    }

    @Test
    @DisplayName("특정 위치에 있는 참가자를 가져온다.")
    void getPlayer() {
        Players players = players();

        assertThat(players.get(Position.of(2))).isEqualTo(Player.of("c", 2));
    }

    @Test
    @DisplayName("범위를 넘어선 위치에서 참가자 정보를 가져오려고 시도하면 예외 처리한다.")
    void throwExceptionIfPositionExceedPlayersSize() {
        Players players = players();

        assertThatThrownBy(() -> players.get(Position.of(5)))
                .isInstanceOf(IndexOutOfBoundsException.class);
    }

    @Test
    @DisplayName("사다리의 지점 개수와 요소 개수가 같은지 비교하여 사다리와 호환 불가능한지 파악한다.")
    void checkIfNotCompatible() {
        Players fivePlayers = players();
        Players fourPlayers = Players.of("pobi", "honux", "crong", "jk");
        Ladder ladder = TestLadder.ladder();

        assertAll(
            () -> assertThat(fivePlayers.isNotCompatible(ladder)).isTrue(),
            () -> assertThat(fourPlayers.isNotCompatible(ladder)).isFalse()
        );
    }
    
}
