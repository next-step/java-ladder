package ladder;

import ladder.domain.*;
import ladder.generator.FixedBridgeGenerator;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static org.assertj.core.api.Assertions.assertThat;

class LadderGameTest {

    @Test
    public void 사다리_타기_게임의_결과를_반환한다() {
        Players players = Players.of(List.of("참가자1", "참가자2", "참가자3"));
        Prizes prizes = Prizes.of(List.of("꽝", "5000", "3000"));
        int height = 3;

        Queue<Bridge> bridges = new LinkedList<>();
        bridges.offer(Bridge.CONNECTED);
        bridges.offer(Bridge.DISCONNECTED);
        bridges.offer(Bridge.DISCONNECTED);
        bridges.offer(Bridge.CONNECTED);
        bridges.offer(Bridge.CONNECTED);
        bridges.offer(Bridge.DISCONNECTED);

        Ladder ladder = Ladder.generateLadder(players.count(), height, new FixedBridgeGenerator(bridges));

        LadderGame ladderGame = new LadderGame(players, prizes, ladder);
        LadderGameResults gameResults = ladderGame.playGame();

        assertThat(gameResults.findPrizeByPlayerName("참가자1").getValue()).isEqualTo("3000");
        assertThat(gameResults.findPrizeByPlayerName("참가자2").getValue()).isEqualTo("5000");
        assertThat(gameResults.findPrizeByPlayerName("참가자3").getValue()).isEqualTo("꽝");
    }

}
