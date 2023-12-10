package nextstep.ladder.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.LinkedList;
import java.util.List;
import org.junit.jupiter.api.Test;

public class LineTest {

    @Test
    public void 다리가_연속으로_True_일때_에러반환_테스트() {
        List<Bridge> bridges = List.of(Bridge.of(true), Bridge.of(true));
        assertThatThrownBy(() -> new Line(5, bridges))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 다리가_사람수의_MINUS1이_아닐때_에러반환_테스트() {
        List<Bridge> bridges = List.of(Bridge.of(true), Bridge.of(false));
        assertThatThrownBy(() -> new Line(5, bridges))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 사람수_1명일때_에러_테스트() {
        assertThatThrownBy(() -> new Line(1, new LinkedList<>()))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
