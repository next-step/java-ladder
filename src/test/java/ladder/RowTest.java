package ladder;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class RowTest {

    @Test
    void create() {
        Row row = Row.from(List.of(true,false,false,true,false));
        assertThat(row).isEqualTo(Row.from(List.of(true,false,false,true,false)));
    }
}
