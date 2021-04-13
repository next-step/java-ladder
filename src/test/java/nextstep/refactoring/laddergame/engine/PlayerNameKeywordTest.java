package nextstep.refactoring.laddergame.engine;

import nextstep.refactoring.laddergame.concrete.Players;
import nextstep.refactoring.laddergame.engine.player.Player;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class PlayerNameKeywordTest {

    @Test
    @DisplayName("all 을 입력받았을 때 모든 참가자를 조회할 수 있는 조건문을 생성한다.")
    void allSearchKeyword() {
        PlayerNameKeyword keyword = new PlayerNameKeyword("all");
        Players players = Players.of("a", "b", "c");

        List<Player> matchedPlayers = players.stream()
                                             .filter(keyword.createCondition())
                                             .collect(Collectors.toList());

        assertThat(matchedPlayers).hasSize(3);
    }

    @Test
    @DisplayName("특정 참가자의 이름을 입력한 경우, 그 참가자만 가져올 수 있는 조건문을 생성한다.")
    void specificSearchKeyword() {
        PlayerNameKeyword keyword = new PlayerNameKeyword("a");
        Players players = Players.of("a", "b", "c");

        List<Player> matchedPlayers = players.stream()
                                             .filter(keyword.createCondition())
                                             .collect(Collectors.toList());

        assertThat(matchedPlayers).hasSize(1);
    }

}
