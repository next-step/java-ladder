package nextstep.ladder.domain.ladder;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class LinesTest {

    @Test
    @DisplayName("size가 0보다 작으면 예외 발생")
    void invalidLinesTest01() {
        Assertions.assertThatThrownBy(() -> new Lines(List.of()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("빈 List<Line>를 통해 Lines을 생성할 수 없습니다.");
    }
}
