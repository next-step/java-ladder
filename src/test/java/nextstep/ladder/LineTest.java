package nextstep.ladder;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LineTest {

    @Test
    void lineExceptionTest() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Lines(1, 2);
        });
    }
}
