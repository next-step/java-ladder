package ladder.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class HeightTest {
    static final int MIN_LENGTH = 1;

    @Test
    @DisplayName("높이가 1보다 작으면 예외를 반환한다.")
    void validateLengthTest_lessThan1() {
        int length = 0;
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Height(length));
    }

    @Test
    @DisplayName("높이가 1 이상이면 Height 객체를 생성한다.")
    void validateLengthTest_GreaterOrEqual1() {
        int length = 1;
        Height height = new Height(length);

        Assertions.assertEquals(height.getLength(), length);
    }
}
