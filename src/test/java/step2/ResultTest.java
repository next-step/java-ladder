package step2;

import org.junit.jupiter.api.Test;
import step2.model.Result;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ResultTest {
    @Test
    public void 결과값_빈값_null() {
        assertThatThrownBy(() -> new Result(null))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> new Result(""))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
