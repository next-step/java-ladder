package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.LinkedHashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

public class LadderGameTest {

    @Test
    void 게임진행() {
        Players players = new StringAsPlayers("kim,dong,hyo").players();
        Ladder ladder = Ladder.of(players.width(), new Height(5), () -> true);
        ExecutionResult executionResult = ExecutionResult.of("꽝,성공,꽝", players.size());

        Map<Name, String> validation = new LinkedHashMap<>();
        validation.put(players.getPlayer(0), "성공");
        validation.put(players.getPlayer(1), "꽝");
        validation.put(players.getPlayer(2), "꽝");

        LadderGame ladderGame = LadderGame.getInstance();
        Map<Name, String> nameStringMap = ladderGame.gamePlay(players, ladder, executionResult);

        assertThat(nameStringMap).isEqualTo(validation);
    }

}
