package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RowTest {

    @Test
    @DisplayName("입력한 위치에 제대로 Line이 그려지는지 테스트")
    public void draw_line_test() {

        // given
        int columnNumber = 5;
        Row row = Row.valueOf(columnNumber);

        // when
        row.drawLine(0);

        // then
        assertThat(row.hasLine(0)).isTrue();
    }
}
