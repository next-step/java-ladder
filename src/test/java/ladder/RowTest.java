package ladder;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class RowTest {

    @Test
    void create() {
        Row row = Row.from(5);
        assertThat(row).isEqualTo(Row.from(5));
    }
}
