package ladder.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class RowTest {
    @Test
    void lengthShouldBeWidthPlusOne() {
        Row randomRow = Row.createRandom(5);
        assertThat(randomRow.size()).isEqualTo(6);
    }
}

