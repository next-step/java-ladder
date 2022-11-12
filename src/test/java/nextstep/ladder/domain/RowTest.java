package nextstep.ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RowTest {

    @Test
    public void create() {
        Row row = Row.ofVertexes(List.of(true, false, true, false));
        assertThat(row.getColumnSize()).isEqualTo(5);

        Row row2 = Row.ofSize(10);
        assertThat(row2.getColumnSize()).isEqualTo(10);

        assertThatThrownBy(() -> Row.ofVertexes(List.of(false, true, false, true, true, false)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void drawOnStrategy() {
        Row row = Row.ofSizeAndStrategy(7, () -> true);
        assertThat(row.hasVertexAt(0)).isTrue();
        assertThat(row.hasVertexAt(1)).isFalse();
        assertThat(row.hasVertexAt(2)).isTrue();
        assertThat(row.hasVertexAt(3)).isFalse();
        assertThat(row.hasVertexAt(4)).isTrue();
        assertThat(row.hasVertexAt(5)).isFalse();
    }
}
