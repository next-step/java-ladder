package laddergame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {

    @Test
    @DisplayName("사다리 타고 내려간 최종 위치")
    void ladder_last_result_index() {
        //given
        List<Line> lines = new ArrayList<>();

        lines.add(new Line(Arrays.asList(new Point(0, Direction.of(false, true))
                , new Point(1, Direction.of(true, false))
                , new Point(2, Direction.of(false, true))
                , new Point(3, Direction.of(true, false)))));

        lines.add(new Line(Arrays.asList(new Point(0, Direction.of(false, false))
                , new Point(1, Direction.of(false, true))
                , new Point(2, Direction.of(true, false))
                , new Point(3, Direction.of(false, false)))));

        lines.add(new Line(Arrays.asList(new Point(0, Direction.of(false, true))
                , new Point(1, Direction.of(true, false))
                , new Point(2, Direction.of(false, true))
                , new Point(3, Direction.of(true, false)))));

        lines.add(new Line(Arrays.asList(new Point(0, Direction.of(false, false))
                , new Point(1, Direction.of(false, true))
                , new Point(2, Direction.of(true, false))
                , new Point(3, Direction.of(false, false)))));

        Ladder ladder = new Ladder(lines);
        //then
        assertThat(ladder.findRewardIndex(0)).isEqualTo(3);
    }

}