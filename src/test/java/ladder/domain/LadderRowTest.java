package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LadderRowTest {
    @Test
    @DisplayName("생성")
    void create() {
        List<Point> points = List.of(Point.first(true), new Point(true, false));
        LadderRow ladderRow = new LadderRow(points);
        assertThat(ladderRow).isEqualTo(new LadderRow(points));
        assertThat(ladderRow.width()).isEqualTo(2);
    }

    @Test
    @DisplayName("넓이 입력")
    void createHeight() {
        int width = 4;
        LadderRow ladderRow = LadderRow.of(width, () -> true);

        List<Point> expectedList = List.of(
                new Point(false, true),
                new Point(true, false),
                new Point(false, true),
                new Point(true, false)
        );
        assertThat(ladderRow).isEqualTo(new LadderRow(expectedList));
    }

    @Test
    @DisplayName("가로 라인의 오른쪽 연결 확인")
    void hasConnections() {
        // given
        int width = 4;
        LadderRow ladderRow = LadderRow.of(width, () -> true);

        // when
        List<Boolean> actual = ladderRow.hasRightConnections();

        // then
        assertThat(actual).isEqualTo(List.of(true, false, true, false));
    }

}