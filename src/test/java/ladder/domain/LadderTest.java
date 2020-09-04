package ladder.domain;

import ladder.domain.rule.DrawRule;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.assertj.core.api.Assertions.assertThat;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class LadderTest {

    private Ladder ladder;
    private DrawRule alwaysDrawRule;

    @BeforeAll
    public void setup() {
        int rowCount = 3;
        int columnCount = 3;
        ladder = Ladder.builder()
                .rowCount(rowCount)
                .columnCount(columnCount)
                .build();
        alwaysDrawRule = () -> true;
    }

    @Test
    @DisplayName("위치에 Line이 잘 생성되는지 확인")
    public void ladder_draw_line_test() {
        // given
        int curRow = 0;
        int curColumn = 0;

        // when
        ladder.drawLine(alwaysDrawRule);

        // then
        Row row = ladder.getRows().get(curColumn);
        assertThat(row.hasLine(curColumn)).isTrue();
    }

    @Test
    @DisplayName("같은 Row에서 인접하게 Line이 생성되지 않는 테스트")
    public void draw_adjacent_line_test() {
        // given
        int curRow = 0;
        int nextColumn = 1;

        // when
        ladder.drawLine(alwaysDrawRule);

        // then
        Row row = ladder.getRows().get(curRow);
        assertThat(row.hasLine(nextColumn)).isFalse();
    }

}
