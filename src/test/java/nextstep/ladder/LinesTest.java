package nextstep.ladder;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LinesTest {

    @Test
    @DisplayName("lines 생성 테스트")
    void createTest() {
        Lines.of(5, 3);
    }

    @Test
    @DisplayName("lines 생성할때 1보다 작은 값이 들어오면 예외 발생")
    void createExceptionTest() {
        Assertions.assertThatThrownBy(() -> Lines.of(0, 3))
                .isInstanceOf(IllegalArgumentException.class).hasMessage("높이는 1 이상이어야 합니다.");
    }
}
