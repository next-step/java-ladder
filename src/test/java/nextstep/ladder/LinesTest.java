package nextstep.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LinesTest {

    @Test
    @DisplayName("lines 생성 테스트")
    void createTest() {
        new Lines(5, 3);
    }

    @Test
    @DisplayName("lines 생성할때 1보다 작은 값이 들어오면 예외 발생")
    void createExceptionTest() {
        new Lines(0,3);
    }
}
