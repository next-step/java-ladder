package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ResultTest {
    @DisplayName("값을 가져온다.")
    @Test
    public void testGetValue() {
        String value = "test";
        Result result = new Result(value);
        assert result.getValue().equals(value);
    }
}
