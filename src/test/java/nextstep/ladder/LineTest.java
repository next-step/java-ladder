package nextstep.ladder;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LineTest {

    @Test
    void 라인은_최소_2명_이상의_참가자가_있어야_한다() {
        assertThatThrownBy(() -> Line.of(0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("라인은 최소 2명 이상의 참가자가 있어야 합니다.");
    }
}
