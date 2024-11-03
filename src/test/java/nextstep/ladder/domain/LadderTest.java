package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderTest {
    @Test
    @DisplayName("성공 - Ladder를 생성했을 떄 주어진 넓이와 높이만큼의 map이 생성된다.")
    void initTest() {
        Ladder ladder = new Ladder(new PositiveNumber(3), new PositiveNumber(5));
        List<Line> ladderLines = ladder.getLadderRows();
        assertThat(ladderLines).hasSize(5);
        ladderLines.forEach(row ->
            assertThat(row.getRow()).hasSize(3)
        );
    }

    /**
     * [ 테스트 사다리 모양 ]
     * |     |     |
     * |-----|     |
     * |     |     |
     */
    @Test
    @DisplayName("getLadderResultIndex 메서드가 사다리 게임 후 마지막 인덱스를 반환한다.")
    void name() {
        PositiveNumber width = new PositiveNumber(3);
        List<Line> map = List.of(
            new Line(new PositiveNumber(3), () -> false),
            new Line(new PositiveNumber(3), () -> true),
            new Line(new PositiveNumber(3), () -> false)
        );
        Ladder ladder = new Ladder(width, map);

        assertThat(ladder.getLadderResultIndex(new Point(0))).isEqualTo(new Point(1));
        assertThat(ladder.getLadderResultIndex(new Point(1))).isEqualTo(new Point(0));
        assertThat(ladder.getLadderResultIndex(new Point(2))).isEqualTo(new Point(2));
    }
}