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
        int countOfLines = 3;
        int countOfPoints = 3;
        ladder = Ladder.builder()
                .countOfLines(countOfLines)
                .countOfPoints(countOfPoints)
                .build();
    }

    @Test
    @DisplayName("사다리 위치에 Line이 잘 생성되는지 확인")
    public void ladder_draw_line_test() {
        // given
        int curLine = 0;
        int curColumn = 0;

        // when
        ladder.drawLine(curLine, curColumn);

        // then
        Line line = ladder.getLines().get(curLine);
        assertThat(line.hasLine(curColumn)).isTrue();
    }

    @Test
    @DisplayName("인접한 Line끼리 선이 생성되지 않는 테스트")
    public void draw_adjacent_line_test() {
        // given
        int curLine = 0;
        int curColumn = 0;
        int nextColumn = 1;
        ladder.drawLine(curLine, curColumn);

        // when
        ladder.drawLine(curLine, nextColumn);

        // then
        Line line = ladder.getLines().get(curLine);
        assertThat(line.hasLine(nextColumn)).isFalse();
    }


    @Test
    @DisplayName("윗 라인에 선이 생성 되어 있는 경우 아래 라인에 선 생성안되는 테스트")
    public void draw_bottom_line_test() {
        // given
        int curLine = 0;
        int curColumn = 0;
        int nextLine = 1;
        int nextColumn = 1;
        ladder.drawLine(curLine, curColumn);

        // when
        ladder.drawLine(nextLine, curColumn);
        ladder.drawLine(nextLine, nextColumn);

        // then
        Line line = ladder.getLines().get(nextLine);
        assertThat(line.hasLine(curColumn)).isFalse();
        assertThat(line.hasLine(nextColumn)).isTrue();
    }

}
