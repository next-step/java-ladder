package nextstep.ladder.Model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class HeightTest {

    private static final int NORMAL_HEIGHT = 5;
    private static final int ERROR_HEIGHT = -5;

    @Test
    @DisplayName("높이가 정상적으로 생성되어지는지에 대한 테스트")
    public void constructorSuccessTest() {
        assertThat(new Height(NORMAL_HEIGHT)).isEqualTo(new Height(NORMAL_HEIGHT));
    }

    @Test
    @DisplayName("높이에 대한 비정상적인 값을 넣어 에러가 발생하는지에 대한 테스트")
    public void constructorErrorTest() {
        assertThatThrownBy(() -> new Height(ERROR_HEIGHT)).isInstanceOf(IllegalArgumentException.class);
    }

}