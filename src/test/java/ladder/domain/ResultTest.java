package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class ResultTest {

    @Test
    void shouldValidateResult() {
        assertThrows(IllegalArgumentException.class, () -> new Result(null));
    }

}
