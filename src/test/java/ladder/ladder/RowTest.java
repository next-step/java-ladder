package ladder.ladder;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import ladder.ladder.Row;
import org.junit.jupiter.api.Test;

class RowTest {

    @Test
    void create() {
        Row row = new Row(List.of(true,false,false,true,false));
        assertThat(row.getPoints().size()).isEqualTo(5);
    }
}
