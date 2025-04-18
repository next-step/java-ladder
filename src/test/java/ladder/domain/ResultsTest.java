package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static ladder.support.TestConstants.RESULTS;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ResultsTest {
    @DisplayName("인덱스로 결과를 가져온다.")
    @Test
    public void testGetResultByIndex() {
        Results results = new Results(RESULTS);
        assertEquals(results.getResult(0).getValue(), RESULTS.get(0));
    }

}
