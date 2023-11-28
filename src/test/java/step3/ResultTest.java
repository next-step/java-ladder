package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import step3.model.LadderGame;
import step3.model.Player;
import step3.model.Prize;
import step3.model.Results;
import step3.teststrategy.PointFalseStrategy;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class ResultTest {

    static Stream<Arguments> generateData() {
        return Stream.of(
                Arguments.of(LadderGame.start(5, 2, new PointFalseStrategy()), List.of(new Player("jane"), new Player("nana")), List.of(new Prize("no"), new Prize("yes")))
        );
    }

    @ParameterizedTest
    @MethodSource("generateData")
    @DisplayName("포인트가 없는 사다리가 있을 때 jane의 상품은 no, nana는 yes가 나온다.")
    void allLadderResultTest(LadderGame ladderGame, List<Player> players, List<Prize> prizes) {
        Results result = new Results(prizes);
        List<String> allResult = result.allLadderResult(players, ladderGame);
        assertThat(allResult.get(0)).isEqualTo("jane : no");
        assertThat(allResult.get(1)).isEqualTo("nana : yes");
    }

    @ParameterizedTest
    @MethodSource("generateData")
    @DisplayName("포인트가 없는 사다리가 있을 때 jane의 결과만 알고 싶을 때 no가 출력된다.")
    void particularPlayerPrize(LadderGame ladderGame, List<Player> players, List<Prize> prizes) {
        Results result = new Results(prizes);
        List<String> allResult = result.particularPlayerPrize(0, ladderGame, prizes);
        assertThat(allResult.get(0)).isEqualTo("no");
    }
}
