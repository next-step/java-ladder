package ladder.domain;

import ladder.domain.ladderlinegenerator.FalseLadderLineGenerator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.IntStream;

public class LadderGameResultTest {
    @DisplayName("사다리 게임 실행 결과 확인")
    @Test
    void ladderGameResultTest() {
        // given
        Players players = Players.createWithNames(List.of("more", "much", "less"));
        List<String> results = List.of("result1", "result2", "result3");
        int height = 4;
        LadderGame ladderGame = new LadderGame(players, results);
        Ladder ladder = new Ladder(height, players.count(), new FalseLadderLineGenerator());

        // when
        LadderGameResult gameResult = ladderGame.play(ladder);

        // then
        IntStream.range(0, players.count()).forEach(i -> {
            Player player = players.getPlayerAtIndex(i);
            Player foundPlayer = gameResult.findPlayer(player.name());
            Assertions.assertThat(foundPlayer.result())
                    .isEqualTo(results.get(i));
        });
    }

    @DisplayName("복잡한 사다리 게임 실행 결과 확인")
    @Test
    void getComplexResult() {
        // given
        List<Boolean> points1 = List.of(true, false);
        LadderLine ladderLineFirst = new LadderLine(points1);
        List<Boolean> points2 = List.of(false, true);
        LadderLine ladderLineSecond = new LadderLine(points2);

        Ladder ladder = new Ladder(List.of(ladderLineFirst, ladderLineSecond));
        Players players = Players.createWithNames(List.of("more", "much", "less"));
        List<String> results = List.of("result1", "result2", "result3");

        LadderGame ladderGame = new LadderGame(players, results);

        // when
        LadderGameResult gameResult = ladderGame.play(ladder);

        // then
        List<Integer> expected = List.of(2, 0, 1);
        IntStream.range(0, players.count()).forEach(i -> {
            Player player = players.getPlayerAtIndex(i);
            Player foundPlayer = gameResult.findPlayer(player.name());
            Assertions.assertThat(foundPlayer.result())
                    .isEqualTo(results.get(expected.get(i)));
        });
    }
}
