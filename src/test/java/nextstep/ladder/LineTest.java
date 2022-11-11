package nextstep.ladder;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertAll;

public class LineTest {
    @Test
    void null_input() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Line(null))
                .withMessageContaining("null이거나 갯수가 너무 작습니다");
    }

    @Test
    void single() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Line(List.of(true)))
                .withMessageContaining("null이거나 갯수가 너무 작습니다");
    }

    @Test
    void consecutive() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Line(List.of(true, true)))
                .withMessageContaining("연속해서 두 지점이 연결");
    }

    @Test
    void connected() {
        Line line = new Line(List.of(true, false, true));
        assertAll(
                () -> assertThat(line.connected(0)).isTrue(),
                () -> assertThat(line.connected(1)).isFalse(),
                () -> assertThat(line.connected(2)).isTrue(),
                () -> assertThatIllegalArgumentException().isThrownBy(() -> line.connected(3))
        );
    }
}
