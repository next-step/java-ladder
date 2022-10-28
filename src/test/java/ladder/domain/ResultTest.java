package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ResultTest {

    @Test
    void create() {
        Result result = new Result("꽝");

        assertThat(result).isEqualTo(new Result("꽝"));
    }
}
