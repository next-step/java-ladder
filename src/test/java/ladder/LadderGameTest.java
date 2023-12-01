package ladder;

import ladder.model.*;
import ladder.teststrategy.PointFalseStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderGameTest {

    @ParameterizedTest
    @CsvSource(value = {"5:2", "4:3", "7:3", "8:4"}, delimiter = ':')
    @DisplayName("라인 수 만큼 세로 | 라인을 만든다.")
    void ladderGameStartTest(int lineHeight, int playerCount) {
        LadderGame ladderGame = LadderGame.start(lineHeight, playerCount, new PointRandomStrategy());
        assertThat(ladderGame.getLines().size()).isEqualTo(lineHeight);
    }

    static Stream<Arguments> generateData() {
        return Stream.of(
                Arguments.of(LadderGame.start(5, 2, new PointFalseStrategy()), List.of(new Player("jane"), new Player("nana")), List.of(new Prize("no"), new Prize("yes")))
        );
    }

    @ParameterizedTest
    @MethodSource("generateData")
    @DisplayName("포인트가 없는 사다리가 있을 때 jane의 상품은 no, nana는 yes가 나온다.")
    void allLadderResultTest(LadderGame ladderGame, List<Player> players, List<Prize> prizes) {
        LadderResult ladderResult = ladderGame.result(players, prizes);

        Map<Player, Prize> results = ladderResult.getResults();
        assertThat(results.get(players.get(0)).getValue()).isEqualTo("no");
        assertThat(results.get(players.get(1)).getValue()).isEqualTo("yes");
    }

    @ParameterizedTest
    @MethodSource("generateData")
    @DisplayName("포인트가 없는 사다리가 있을 때 jane의 결과만 알고 싶을 때 no가 출력된다.")
    void particularPlayerPrize(LadderGame ladderGame, List<Player> players, List<Prize> prizes) {
        LadderResult ladderResult = ladderGame.result(players, prizes);

        Map<Player, Prize> results = ladderResult.getResults();
        assertThat(results.get(players.get(0)).getValue()).isEqualTo("no");
    }
}
