package nextstep.ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LadderResultTest {
    @Test
    void 사다리게임_실행_결과() {
        Ladder ladder = new Ladder(4, 5);
        List<String> names = Arrays.asList("kimun", "leeyp", "kimyh", "abcd");
        List<String> executeResult = Arrays.asList("꽝", "5000", "3000", "꽝");
        LadderRequireElement ladderRequireElement = new LadderRequireElement(names, executeResult);


        LadderResult ladderResult = new LadderResult(ladder, ladderRequireElement);
        assertThat(ladderResult.findResultByName("kimun")).hasSize(1);
    }

    @Test
    void 사다리게임_전체_결과() {
        Ladder ladder = new Ladder(4, 5);
        List<String> names = Arrays.asList("kimun", "leeyp", "kimyh", "abcd");
        List<String> executeResult = Arrays.asList("꽝", "5000", "3000", "꽝");
        LadderRequireElement ladderRequireElement = new LadderRequireElement(names, executeResult);


        LadderResult ladderResult = new LadderResult(ladder, ladderRequireElement);
        assertThat(ladderResult.findResultByName("all")).hasSize(4);
    }
}