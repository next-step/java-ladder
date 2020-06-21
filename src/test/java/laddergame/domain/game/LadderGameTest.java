package laddergame.domain.game;

import laddergame.domain.ladder.Ladder;
import laddergame.domain.player.Players;
import laddergame.domain.vo.Height;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LadderGameTest {

    @DisplayName("사다리 게임을 실행하고 GameResult를 반환한다.")
    @Test
    void generateGameResult() {
        Players players = new Players(new String[]{"pobi", "crong", "horox"});
        Prizes prizes = new Prizes(new String[]{"꽝", "2000", "꽝"});
        Ladder ladder = new Ladder(new Height(3), 3, () -> true);
        LadderGame ladderGame = new LadderGame(ladder);

        assertThat(ladderGame.startGame(players, prizes)).isInstanceOf(GameResult.class);
    }
}