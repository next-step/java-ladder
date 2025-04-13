package nextstep.ladder.domain.line;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class DimensionTest {

    @DisplayName("Height 인스턴스 만들기")
    @Test
    public void testConstructor() {
        assertDoesNotThrow(() -> new Dimension(2));
    }

    @DisplayName("높이가 0 이하이면 예외를 반환한다.")
    @Test
    public void testConstructor_throwException() {
        assertThatThrownBy(() -> new Dimension(0))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("높이는 1 이상이여야 합니다.");
    }
}
