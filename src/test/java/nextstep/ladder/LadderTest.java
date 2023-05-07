package nextstep.ladder;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LadderTest {

    @Test
    void getLines() {
        List<Line> expect = List.of(
                new Line(List.of(true, false, true, false)),
                new Line(List.of(true, false, false, true)),
                new Line(List.of(true, false, false, false)),
                new Line(List.of(false, false, true, false)),
                new Line(List.of(true, false, true, false))
        );
        Ladder ladder = new Ladder(expect);
        assertThat(ladder.getLines())
                .isEqualTo(expect);
    }

    @Test
    void 잘못된_사다리() {
        assertThatThrownBy(() -> new Ladder(List.of(
                new Line(List.of(true, true, true, false)),
                new Line(List.of(true, false, false, true)),
                new Line(List.of(true, false, false, false)),
                new Line(List.of(false, false, true, false)),
                new Line(List.of(true, false, true, false))
        )))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("잘못된 사다리입니다.");
    }
}
