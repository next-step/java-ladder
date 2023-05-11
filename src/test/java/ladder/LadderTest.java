package ladder;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.List;
import org.junit.jupiter.api.Test;

public class LadderTest {

    @Test
    void 사다리_높이_너비_생성() {
        Ladder actual = Ladder.of(5, 3);
        assertAll(
            () -> assertThat(actual.height()).isEqualTo(5),
            () -> assertThat(actual.width()).isEqualTo(3)
        );
    }

    @Test
    void 사다리생성() {
        Line line = Line.of(List.of(false, false));
        assertAll(
            () -> assertThat(Ladder.of(List.of(line, line))).isEqualTo(Ladder.of(List.of(line, line))),
            () -> assertThat(Ladder.of(List.of(line, line)).height()).isEqualTo(2)
        );
    }

}
