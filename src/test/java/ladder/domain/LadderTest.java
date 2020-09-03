package ladder.domain;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.assertj.core.api.Assertions.assertThat;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class LadderTest {

    private Ladder ladder;

    @BeforeAll
    public void setup() {
        int rowCount = 3;
        int columnCount = 3;
        ladder = Ladder.builder().rowCount(rowCount)
                .columnCount(columnCount)
                .build();
    }

    @Test
    @DisplayName("위치에 Line이 잘 생성되는지 확인")
    public void ladder_draw_line_test() {
        // given
        int curRow = 0;
        int curColumn = 0;

        // when
        ladder.drawLine(curRow, curColumn);

        // then
        Row row = ladder.getRows().get(curColumn);
        assertThat(row.hasLine(curColumn)).isTrue();
    }

    @Test
    @DisplayName("같은 Row에서 인접하게 Line이 생성되지 않는 테스트")
    public void draw_adjacent_line_test() {
        // given
        int curRow = 0;
        int curColumn = 0;
        int nextColumn = 1;
        ladder.drawLine(curRow, curColumn);

        // when
        ladder.drawLine(curRow, nextColumn);

        // then
        Row row = ladder.getRows().get(curRow);
        assertThat(row.hasLine(nextColumn)).isFalse();
    }


    @Test
    @DisplayName("위의 Row에 Line이 생성되어 있는 경우 아래에 Line 생성 안되는 테스트")
    public void draw_bottom_line_test() {
        // given
        int curRow = 0;
        int curColumn = 0;
        int nextRow = 1;
        int nextColumn = 1;
        ladder.drawLine(curRow, curColumn);

        // when
        ladder.drawLine(nextRow, curColumn);
        ladder.drawLine(nextRow, nextColumn);

        // then
        Row row = ladder.getRows().get(nextRow);
        assertThat(row.hasLine(curColumn)).isFalse();
        assertThat(row.hasLine(nextColumn)).isTrue();
    }

}
