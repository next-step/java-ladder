package ladder2.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderJudgeTest {

    @Test
    @DisplayName("참가자와 사다리 결과를 알맞게 매칭시킨다")
    void judge() {
        Players players = makePlayers();
        Prizes prizes = makePrizes();
        LadderJudge judge = new LadderJudge(players, prizes);

        LadderResult ladderResult = makeLadderResult();
        judge.judge(ladderResult);

        assertThat(players.get(0).prize().name()).isEqualTo("2");
        assertThat(players.get(1).prize().name()).isEqualTo("0");
        assertThat(players.get(2).prize().name()).isEqualTo("3");
        assertThat(players.get(3).prize().name()).isEqualTo("1");
    }

    private Prizes makePrizes() {
        List<Prize> prizes = IntStream.range(0, 4)
            .mapToObj(i -> new Prize(i, String.valueOf(i)))
            .collect(Collectors.toList());
        return new Prizes(prizes);
    }

    private static Players makePlayers() {
        List<String> playerNames = List.of("a", "b", "c", "d");
        List<Player> players = IntStream.range(0, playerNames.size())
            .mapToObj(i -> new Player(i, playerNames.get(i)))
            .collect(Collectors.toList());
        return new Players(players);
    }

    private LadderResult makeLadderResult() {
        Map<Integer, Integer> resultIndices = Map.of(
            0, 2,
            1, 0,
            2, 3,
            3, 1
        );
        return new LadderResult(resultIndices);
    }
}
