package step2.domain;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import step2.strategy.RandomLineCreateStrategy;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {

    @Test
    void 라인을_생성한다() {
        //given
        Line line = Line.create(4, (count) -> Arrays.asList(true, false, true));
        //when & then
        assertThat(line).isNotNull();
    }

    @Test
    void 라인은_참가자_수_보다_1_적게_생성된다() {
        //given
        Line line = Line.create(4, (count) -> Arrays.asList(true, false, true));
        //when & then
        assertThat(line.getLineSize()).isEqualTo(3);
    }

    @RepeatedTest(10)
    void 라인은_겹치게_생성되지_않는다() {
        //given
        int participantCount = 4;
        Line line = Line.create(participantCount, new RandomLineCreateStrategy());
        //when
        List<Boolean> lines = line.getLine();
        //then
        for (int step = 1; step < participantCount - 1; step++) {
            assertThat(Boolean.logicalAnd(lines.get(step), lines.get(step - 1))).isFalse();
        }
    }

    @RepeatedTest(10)
    void 라인의_끝은_다리가_생성되지_않는다() {
        //given
        int participantCount = 10;
        Line line = Line.create(participantCount, new RandomLineCreateStrategy());
        //when
        List<Boolean> lines = line.getLine();
        //then
        Boolean endLine = lines.get(participantCount - 1);
        assertThat(endLine).isFalse();
    }
}
