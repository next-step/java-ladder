package ladder.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;

public class LadderResultTest {
    @Test
    void create() {
        Map<Person, String> result = new LinkedHashMap<>();
        result.put(PersonsTest.pobi, "3000");
        result.put(PersonsTest.honux, "꽝");
        LadderResult ladderResult = LadderResult.of(result);

        assertThat(ladderResult).isEqualTo(LadderResult.of(result));
    }

    /*
    @Test
    void move() {
        Persons persons = Persons.of(Arrays.asList(PersonsTest.pobi, PersonsTest.honux));
        Line line1 = new Line(Arrays.asList(true, false));
        Line line2 = new Line(Arrays.asList(false, true));
        Ladder ladder = new Ladder(Arrays.asList(line1, line2));

        LadderResult ladderResult = of
    }

     */
}
