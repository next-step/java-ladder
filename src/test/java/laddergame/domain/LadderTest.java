package laddergame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {

    @Test
    @DisplayName("사다리 타고 내려간 최종 위치 반환")
    void ladder_last_result_index() {
        //given
        List<Line> lines = new ArrayList<>();
        lines.add(new Line(Arrays.asList(false, true, false, true)));
        lines.add(new Line(Arrays.asList(false, false, true, false)));
        lines.add(new Line(Arrays.asList(false, true, false, true)));
        lines.add(new Line(Arrays.asList(false, false, true, false)));
        Ladder ladder = new Ladder(lines);
        //then
        assertThat(ladder.getResultIndex(0)).isEqualTo(3);
    }

}