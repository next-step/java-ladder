package nextstep.ladder;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import nextstep.ladder.domain.Line;
import nextstep.ladder.exception.LadderException;
import nextstep.ladder.exception.LineException;

public class LineTest {
    @DisplayName("사다리 선을 만든다.")
    @Test
    public void create_success_bridge() {
        final Line line = new Line(2);
        line.makeBridge(0, () -> true);
    }

    @DisplayName("사다리 위치를 벗어나서 선을 만들 수 없다.")
    @ValueSource(ints = { -1, 1 })
    @ParameterizedTest
    public void create_fail_bridge() {
        final Line line = new Line(2);
        assertThatThrownBy(() -> line.makeBridge(1, () -> true))
                .isInstanceOf(LineException.class)
                .hasMessage("올바르지 않은 위치입니다.");
    }

    @DisplayName("연속되지 않게 사다리 선을 만들 수 있다.")
    @Test
    public void create_bridge_not_continuous() {
        final Line line = new Line(4);
        line.makeBridge(0, () -> true);
        line.makeBridge(2, () -> true);
        for (int i = 1; i < 3; i++) {
            System.out.println(line.hasBridge(i));
        }
    }

    @DisplayName("사다리 선은 연속해서 만들어질 수 없다.")
    @Test
    public void invalid_continuous() {
        final Line line = new Line(3);
        line.makeBridge(0, () -> true);
        assertThatThrownBy(() -> line.makeBridge(1, () -> true))
                .isInstanceOf(LadderException.class)
                .hasMessageContaining("이미 다리가 있습니다. 연속해서 만들 수 없습니다.");
    }
}
