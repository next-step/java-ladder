package ladder.engine;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ResultTest {

    @Test
    void put_and_get() {
        Result result = new Result();
        result.put(0, 1);
        assertThat(result.get(0)).isEqualTo(1);
    }
}
