package ladder.game.domain;

import ladder.common.StubBuilder;
import ladder.game.ui.LadderGame;
import ladder.ladder.domain.Ladder;
import ladder.ladder.domain.LadderLine;
import ladder.ladder.domain.Point;
import ladder.player.domain.Player;
import ladder.player.domain.Players;
import ladder.prize.domain.Prize;
import ladder.prize.domain.Prizes;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class LadderGameTest {

    @DisplayName("사다리게임 정보와 높이를 가지고 사다리 게임을 시작 할 수 있다")
    @Test
    public void ladderGameInitTest() {
        Players players = Players.of(Arrays.asList("정원", "자바"));
        Prizes prizes = Prizes.of(Arrays.asList("1등", "꽝"));
        LadderGameInfo ladderGameInfo = LadderGameInfo.of(players, prizes);

        LadderGame ladderGame = LadderGame.init(ladderGameInfo, 5);
        LadderGameResults gameResults = ladderGame.play();

        assertThat(gameResults).isNotNull();
    }

    @DisplayName("사다리 게임을 시작하면 참여자들의 결과를 알 수 있다")
    @Test
    public void ladderGamePlayTest() {
        Players players = Players.of(Arrays.asList("정원", "자바", "jwee0330"));
        Prizes prizes = Prizes.of(Arrays.asList("1등", "꽝", "꽝"));
        LadderGameInfo ladderGameInfo = LadderGameInfo.of(players, prizes);

        Point point00 = StubBuilder.buildStubPoint(0, false, true);
        Point point01 = StubBuilder.buildStubPoint(1, true, false);
        Point point02 = StubBuilder.buildStubPoint(2, false, false);
        Point point10 = StubBuilder.buildStubPoint(0, false, true);
        Point point11 = StubBuilder.buildStubPoint(1, true, false);
        Point point12 = StubBuilder.buildStubPoint(2, false, false);

        LadderLine ladderLine1 = LadderLine.of(Arrays.asList(point00, point01, point02));
        LadderLine ladderLine2 = LadderLine.of(Arrays.asList(point10, point11, point12));
        Ladder ladder = Ladder.of(Arrays.asList(ladderLine1, ladderLine2));

        LadderGame ladderGame = LadderGame.of(ladder, ladderGameInfo);
        LadderGameResults gameResults = ladderGame.play();

        Map<Player, Prize> expected = new HashMap<>();
        expected.put(Player.of("정원"), Prize.of("1등"));
        expected.put(Player.of("자바"), Prize.of("꽝"));
        expected.put(Player.of("jwee0330"), Prize.of("꽝"));

        assertThat(gameResults.getAllPlayersResult())
                .isEqualTo(expected);
    }

}
