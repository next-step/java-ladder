package ladder.ladder;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class RowTest {

    @Test
    void create() {
        RowGenerator rowGenerator = new RowGenerator();
        Row row = rowGenerator.create(5);
        assertThat(row.getPoints().size()).isEqualTo(5);
    }
}
