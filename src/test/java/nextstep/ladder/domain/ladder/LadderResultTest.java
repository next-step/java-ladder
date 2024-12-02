package nextstep.ladder.domain.ladder;

import nextstep.ladder.domain.player.PlayerTest;
import nextstep.ladder.domain.player.Players;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class LadderResultTest {
    public static LadderResult ladderResult = new LadderResult(List.of("꽝", "5000원", "10000원", "15000원"));

    @Test
    void create_성공() {
        Players players = new Players(List.of(PlayerTest.PLAYER1, PlayerTest.PLAYER1));
        List<String> resultList = List.of("꽝", "5000원");

        LadderResult ladderResult = new LadderResult(resultList, players.playerCount());

        Assertions.assertThat(ladderResult).isNotNull();
    }

    @Test
    @DisplayName("사다리 게임 결과 수와 플레이어의 수는 동일해야 한다")
    void create_실패() {
        Players players = new Players(List.of(PlayerTest.PLAYER1, PlayerTest.PLAYER1));
        List<String> resultList = List.of("꽝", "5000원", "10000원");

        Assertions.assertThatThrownBy(() -> {
            LadderResult ladderResult = new LadderResult(resultList, players.playerCount());
        }).isInstanceOf(IllegalArgumentException.class);
    }
}