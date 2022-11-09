package nextstep.ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RowTest {

    @Test
    public void create() {
        Row row = new Row(List.of(true, false, true, false));
        assertThat(row.getColumnSize()).isEqualTo(5);

        Row row2 = new Row(10);
        assertThat(row2.getColumnSize()).isEqualTo(10);

        assertThatThrownBy(() -> new Row(List.of(false, true, false, true, true, false)))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
