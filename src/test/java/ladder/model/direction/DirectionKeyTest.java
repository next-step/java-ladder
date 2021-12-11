package ladder.model.direction;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class DirectionKeyTest {

    @ParameterizedTest
    @CsvSource(value = {"false,false,1", "false,true,2", "true,false,3"})
    @DisplayName("값에 맞는 키값 가져오는지 테스트")
    void getRightKeyTest(boolean left, boolean right, int key) {
        assertThat(DirectionKey.get(left,right)).isEqualTo(key);
    }

    @Test
    @DisplayName("선과 선이 나란히일때 예외발생 테스트")
    void getRightKeyTest() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> DirectionKey.get(true,true))
                .withMessage("선과 선은 나란히 그릴 수 없습니다.");
    }
}
