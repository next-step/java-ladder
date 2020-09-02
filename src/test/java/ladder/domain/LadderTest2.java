package ladder.domain;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.assertj.core.api.Assertions.assertThat;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class LadderTest2 {

    private Ladder2 ladder2;

    @BeforeAll
    public void setup() {
        int rowNumber = 3;
        int columnNumber = 3;
        ladder2 = Ladder2.builder().rowNumber(rowNumber)
                .columnNumber(columnNumber)
                .build();
    }

    @Test
    @DisplayName("위치에 Line이 잘 생성되는지 확인")
    public void ladder_draw_line_test() {
        // given
        int curRow = 0;
        int curColumn = 0;

        // when
        ladder2.drawLine(curRow, curColumn);

        // then
        Row row = ladder2.getRows().get(curColumn);
        assertThat(row.hasLine(curColumn)).isTrue();
    }

    @Test
    @DisplayName("같은 Row에서 인접하게 Line이 생성되지 않는 테스트")
    public void draw_adjacent_line_test() {
        // given
        int curRow = 0;
        int curColumn = 0;
        int nextColumn = 1;
        ladder2.drawLine(curRow, curColumn);

        // when
        ladder2.drawLine(curRow, nextColumn);

        // then
        Row row = ladder2.getRows().get(curRow);
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
        ladder2.drawLine(curRow, curColumn);

        // when
        ladder2.drawLine(nextRow, curColumn);
        ladder2.drawLine(nextRow, nextColumn);

        // then
        Row row = ladder2.getRows().get(nextRow);
        assertThat(row.hasLine(curColumn)).isFalse();
        assertThat(row.hasLine(nextColumn)).isTrue();
    }

}
