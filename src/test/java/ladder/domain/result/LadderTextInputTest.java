package ladder.domain.result;

import ladder.exception.InputLengthException;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LadderTextInputTest {

    @Test
    void create() {
        LadderTextInput result = new LadderTextInput("꽝");

        assertThat(result).isEqualTo(new LadderTextInput("꽝"));
    }

    @Test
    void valid_length() {
        assertThatThrownBy(() -> new LadderTextInput("500000")).isInstanceOf(InputLengthException.class);
    }
}
