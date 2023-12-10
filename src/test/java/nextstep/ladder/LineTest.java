package nextstep.ladder;

import nextstep.ladder.domain.Line;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LineTest {

    @Test
    void 라인은_최소_1개_이상의_포인트가_있어야_한다() {
        assertThatThrownBy(() -> new Line(List.of()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("라인은 최소 1개 이상의 포인트가 있어야 합니다.");
    }
}
