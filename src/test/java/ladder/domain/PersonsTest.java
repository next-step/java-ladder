package ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.*;

public class PersonsTest {
    @Test
    void create() {
        Persons persons = Persons.of(Arrays.asList("pobi", "honux"));
        assertThat(persons).isEqualTo(Persons.of(Arrays.asList("pobi", "honux")));
    }

    @Test
    void findResult() {
        List<String> stringNames = Arrays.asList("a", "b", "c", "d");
        List<String> results = Arrays.asList("가", "나", "다", "라");
        LadderResult ladderResult2 = LadderResult.of(results);
        Names names = Names.of(stringNames);

        Map<String, String> answerResult = new LinkedHashMap<>();
        List<String> answerList = Arrays.asList("다", "가", "라", "나");
        IntStream.range(0, 4).forEachOrdered(number -> answerResult.put(stringNames.get(number), answerList.get(number)));

        assertThat(names.mappingFinalResult(LadderTest.ladder, ladderResult2)).isEqualTo(answerResult);
    }
}
