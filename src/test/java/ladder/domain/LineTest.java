package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LineTest {

    @Test
    @DisplayName("사다리 라인을 생성한다.")
    void createLine() {
        assertThat(new Line(3, () -> true)).isEqualTo(new Line(true, false, true));
        assertThat(new Line(3, () -> false)).isEqualTo(new Line(false, false, false));
    }

    @Test
    @DisplayName("사다리의 라인 하나가 반환된다.")
    void getList() {
        assertThat(new Line(true, false, true).getList()).isEqualTo(List.of(true, false, true));
    }

}