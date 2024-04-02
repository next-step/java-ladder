package nextstep.step2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ResultsTest {

    @Test
    void 정상적으로_results_객체가_생성된다() {
        String input = "꽝,5000,꽝,3000";
        Results results = new Results(input);
        assertEquals(4, results.getResults().size());
    }

    @Test
    void 결과에는_공백이_있을_수_없다() {
        String input = "";
        assertThrows(IllegalArgumentException.class, () -> new Results(input));
    }

    @Test
    void 결과에는_null이_있을_수_없다() {
        String input = null;
        assertThrows(IllegalArgumentException.class, () -> new Results(input));
    }
}
