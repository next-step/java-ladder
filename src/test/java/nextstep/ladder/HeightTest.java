package nextstep.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class HeightTest {

    @Test
    @DisplayName("높이 생성 테스트")
    void createTest() {
        new Height(5);
    }

    @Test
    @DisplayName("높이 생성할때 1보다 작은 값이 들어오면 예외 발생")
    void createExceptionTest() {
        new Height(0);
    }
}
