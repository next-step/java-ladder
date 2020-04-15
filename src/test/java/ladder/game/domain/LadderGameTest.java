package ladder.game.domain;

import ladder.common.TestFeature;
import ladder.ladder.domain.Ladder;
import ladder.ladder.domain.LadderLine;
import ladder.player.domain.Player;
import ladder.player.domain.Players;
import ladder.prize.domain.Prize;
import ladder.prize.domain.Prizes;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
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
        Players players = Players.of(Arrays.asList("정원", "자바"));
        Prizes prizes = Prizes.of(Arrays.asList("1등", "꽝"));
        LadderGameInfo ladderGameInfo = LadderGameInfo.of(players, prizes);

        LadderGame ladderGame = LadderGame.init(ladderGameInfo, 5);
        LadderGameResults gameResults = ladderGame.play();

        assertThat(gameResults).isNotNull();
    }

    @DisplayName("사다리 게임을 수행하여 참여자들의 결과를 반환한다.")
    @Test
    public void totalGameTest() {
        /**
         *   JW    2     3     4
         *   |-----|     |-----|
         *   |     |-----|     |
         *   |-----|     |     |
         *   |-----|     |-----|
         *  꽝(2) 꽝(4) 꽝(3) 1등(JW)
         */
        LadderLine firstLadderLine = LadderLine.of(TestFeature.generateLines(true, false, true, true));
        LadderLine secondLadderLine = LadderLine.of(TestFeature.generateLines(false, true, false, false));
        LadderLine thirdLadderLine = LadderLine.of(TestFeature.generateLines(true, false, false, true));
        LadderLine fourthLadderLine = LadderLine.of(TestFeature.generateLines(false, false, false, false));
        Ladder ladder = Ladder.of(firstLadderLine, secondLadderLine, thirdLadderLine, fourthLadderLine);

        LadderGameInfo ladderGameInfo = LadderGameInfo.of(
                Players.of(Arrays.asList("JW", "2", "3", "4")), Prizes.of(Arrays.asList("꽝", "꽝", "꽝", "1등")));

        LadderGame ladderGame = LadderGame.of(ladder, ladderGameInfo);
        LadderGameResults ladderGameResults = ladderGame.play();

        Map<Player, Prize> specificWinner = ladderGameResults.getSpecificWinner("JW");
        assertThat(specificWinner).containsKey(Player.of("JW"));
        assertThat(specificWinner).containsValue(Prize.of("1등"));

    }


}
