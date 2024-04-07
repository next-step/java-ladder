package nextstep.ladder.domain.ladder;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class LineTest {

    @Test
    @DisplayName("n-1 번째 이어진 경우 n번째는 이어질 수 없음.")
    void lineInvalid01Test() {
        Assertions.assertThatThrownBy(() -> new Line(true, true))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("연속된 연결을 될 수 없습니다.");
    }

    @Test
    @DisplayName("사다리 폭은 1보다 작은 경우 예외 발생")
    void lineInvalid02Test() {
        Assertions.assertThatThrownBy(() -> new Line(List.of()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("빈 List<Point>를 통해 Line을 생성할 수 없습니다.");
    }
}
