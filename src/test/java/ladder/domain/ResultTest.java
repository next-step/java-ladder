package ladder.domain;

import ladder.exception.InputLengthException;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ResultTest {

    @Test
    void create() {
        Result result = new Result("꽝");

        assertThat(result).isEqualTo(new Result("꽝"));
    }

    @Test
    void valid_length() {
        assertThatThrownBy(() -> new Result("500000")).isInstanceOf(InputLengthException.class);
    }
}
