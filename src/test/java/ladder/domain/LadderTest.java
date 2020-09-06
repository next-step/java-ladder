package ladder.domain;

import ladder.domain.rule.DrawRule;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class LadderTest {

    private Ladder ladder;
    private DrawRule alwaysDrawRule;

    @BeforeAll
    public void setup() {
        int rowCount = 4;
        int columnCount = 4;
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

    @Test
    @DisplayName("사다리 길찾기 테스트")
    public void search_line_test() {
        // given
        Map<Integer, Integer> result = new HashMap<>();
        result.put(0, 0);
        result.put(1, 1);
        result.put(2, 2);
        result.put(3, 3);
        LadderResult ladderResult = LadderResult.of(result);

        // when & then
        assertThat(ladder.searchLine()).isEqualTo(ladderResult);
    }


    @Test
    @DisplayName("현재 도착지(=마지막 Row) 위에 있는지 확인하는 테스트")
    void on_destination() {
        assertThat(ladder.onDestination(new Position(3, 0))).isTrue();
        assertThat(ladder.onDestination(new Position(1, 0))).isFalse();
    }

    @Test
    @DisplayName("현재 시작점(=첫번재 Row) 위에 있는지 확인하는 테스트")
    void on_firstColumn() {
        assertThat(ladder.onFirstColumn(new Position(0, 0))).isTrue();
        assertThat(ladder.onFirstColumn(new Position(0, 1))).isFalse();
    }

    @Test
    @DisplayName("현재 마지막 Column 위에 있는지 확인하는 테스트")
    void on_lastColumn() {
        assertThat(ladder.onLastColumn(new Position(0, 3))).isTrue();
        assertThat(ladder.onLastColumn(new Position(0, 1))).isFalse();
    }

}
