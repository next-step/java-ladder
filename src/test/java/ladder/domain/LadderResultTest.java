package ladder.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.*;

public class LadderResultTest {
    @Test
    void create() {
        List<String> results = Arrays.asList("pobi", "honux");
        LadderResult ladderResult = LadderResult.of(results);

        assertThat(ladderResult).isEqualTo(LadderResult.of(results));
    }


    @Test
    void findResult() {
        List<String> names = Arrays.asList("a", "b", "c", "d");
        List<String> result = Arrays.asList("가", "나", "다", "라");
        LadderResult ladderResult = LadderResult.of(result);

        List<String> answers = Arrays.asList("다", "가", "라", "나");

        assertThat(ladderResult.findLadderResult(LadderTest.ladder)).isEqualTo(answers);
    }

}
