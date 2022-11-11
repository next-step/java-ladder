package nextstep.ladder;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

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
}
