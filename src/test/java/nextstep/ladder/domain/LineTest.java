package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LineTest {
    @Test
    @DisplayName("연속된 true 값 생성 불가")
    void constructor() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Line(List.of(true, true, true)));
    }

    @Test
    @DisplayName("포인트 개수")
    void size() {
        Line line = new Line(List.of(true, false, true));
        assertThat(line).isEqualTo(3);
    }

    @Test
    @DisplayName("포인트 인덱스 참인지 확인")
    void isPointTrue() {
        Line line = new Line(List.of(true, false, true));
        assertThat(line.isPointTrue(1)).isTrue();
        assertThat(line.isPointTrue(2)).isFalse();
        assertThat(line.isPointTrue(3)).isTrue();
    }
}
