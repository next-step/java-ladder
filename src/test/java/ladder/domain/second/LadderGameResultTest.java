package ladder.domain.second;

import ladder.domain.PlayerName;
import ladder.domain.Players;
import ladder.domain.SequentialConnectionStrategy;
import ladder.engine.LadderCreator;
import ladder.engine.LadderResult;
import ladder.factory.LadderFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LadderGameResultTest {
    @DisplayName("step4에서 만든 second 패키지로 사다리 게임 결과 생성 확인")
    @Test
    void result() {
        Players players = new Players("user1, user2, user3, user4");
        LadderCreator ladderCreator = LadderFactory.create(5, players.countOfPlayers(), new SequentialConnectionStrategy());
        LadderResult ladderResult = new LadderGameResult("1등,2등,3등,4등");
        Players resultPlayers = ladderResult.result(players, ladderCreator);
        Map<PlayerName, String> results = resultPlayers.getPlayers();
        assertAll(
                () -> assertThat(results.get(new PlayerName("user1"))).isEqualTo("2등"),
                () -> assertThat(results.get(new PlayerName("user2"))).isEqualTo("1등"),
                () -> assertThat(results.get(new PlayerName("user3"))).isEqualTo("4등"),
                () -> assertThat(results.get(new PlayerName("user4"))).isEqualTo("3등")
        );
    }
}