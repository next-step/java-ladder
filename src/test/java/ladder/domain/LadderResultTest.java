package ladder.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.*;

public class LadderResultTest {
    @Test
    void create() {
        Map<String, String> result = new LinkedHashMap<>();
        result.put("pobi", "3000");
        result.put("honux", "꽝");
        LadderResult ladderResult = LadderResult.of(result);

        assertThat(ladderResult).isEqualTo(LadderResult.of(result));
    }


    @Test
    void findResult() {
        List<String> names = Arrays.asList("a", "b", "c", "d");
        List<String> result = Arrays.asList("가", "나", "다", "라");
        LadderResult ladderResult = LadderResult.of(names);
        ladderResult.findLadderResult(LadderTest.ladder, result);

        Map<String, String> answerResult = new LinkedHashMap<>();
        List<String> answerList = Arrays.asList("다", "가", "라", "나");
        IntStream.range(0, 4).forEachOrdered(number -> answerResult.put(names.get(number), answerList.get(number)));

        assertThat(ladderResult).isEqualTo(LadderResult.of(answerResult));
    }

}
