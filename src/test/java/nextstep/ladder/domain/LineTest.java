package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThatCode;

import org.junit.jupiter.api.Test;

public class LineTest {

    @Test
    void create() {
        assertThatCode(() -> Line.of(5, new RandomBooleanStrategy())).doesNotThrowAnyException();
    }
}
