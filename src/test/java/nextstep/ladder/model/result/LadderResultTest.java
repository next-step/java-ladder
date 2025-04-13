package nextstep.ladder.model.result;

import nextstep.ladder.model.ladder.Height;
import nextstep.ladder.model.ladder.Ladder;
import nextstep.ladder.model.ladder.Position;
import nextstep.ladder.model.player.Player;
import nextstep.ladder.model.player.Players;
import nextstep.ladder.strategy.TestPointGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderResultTest {
    
    @Test
    @DisplayName("사다리 결과 생성 테스트")
    void createLadderResult() {
        Player pobi = new Player("pobi");
        Player crong = new Player("crong");
        Player honux = new Player("honux");
        Players players = Players.from(Arrays.asList(pobi, crong, honux));

        Result result1 = new Result("당첨");
        Result result2 = new Result("꽝");
        Result result3 = new Result("5000원");
        List<Result> resultValues = Arrays.asList(result1, result2, result3);

        Ladder ladder = new Ladder(players, new Height(1), new TestPointGenerator(false));
        LadderResult ladderResult = new LadderResult(players, resultValues, ladder);

        assertThat(ladderResult.getResult(pobi)).isEqualTo(result1);
        assertThat(ladderResult.getResult(crong)).isEqualTo(result2);
        assertThat(ladderResult.getResult(honux)).isEqualTo(result3);
    }
    
    @Test
    @DisplayName("모든 결과 조회 테스트")
    void getAllResults() {
        Player pobi = new Player("pobi");
        Player crong = new Player("crong");
        Players players = Players.from(Arrays.asList(pobi, crong));

        Result result1 = new Result("당첨");
        Result result2 = new Result("꽝");
        List<Result> resultValues = Arrays.asList(result1, result2);

        Ladder ladder = new Ladder(players, new Height(1), new TestPointGenerator(false));
        LadderResult ladderResult = new LadderResult(players, resultValues, ladder);

        Map<Player, Result> allResults = ladderResult.getAllResults();
        assertThat(allResults).hasSize(2);
        assertThat(allResults.get(pobi)).isEqualTo(result1);
        assertThat(allResults.get(crong)).isEqualTo(result2);
    }
    
    @Test
    @DisplayName("위치가 바뀌는 사다리 결과 테스트")
    void positionChangedResult() {
        Player pobi = new Player("pobi");
        Player crong = new Player("crong");
        Players players = Players.from(Arrays.asList(pobi, crong));

        Result result1 = new Result("당첨");
        Result result2 = new Result("꽝");
        List<Result> resultValues = Arrays.asList(result1, result2);

        Ladder ladder = new Ladder(players, new Height(1), new TestPointGenerator(false)) {
            @Override
            public Position run(final Position start) {
                if (start.equals(new Position(0))) {
                    return new Position(1);
                }
                return new Position(0);
            }
        };

        LadderResult ladderResult = new LadderResult(players, resultValues, ladder);

        assertThat(ladderResult.getResult(pobi)).isEqualTo(result2);
        assertThat(ladderResult.getResult(crong)).isEqualTo(result1);
    }
} 
