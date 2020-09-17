package nextstep.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PointTest {

    @ParameterizedTest
    @ValueSource(booleans = {true, false})
    @DisplayName("생성자 정상 작동")
    void create(boolean connection) {
        assertNotNull(Point.of(connection));
    }

    @Test
    @DisplayName("객체 재사용 확인")
    void reusable() {
        assertTrue(Point.of(true) == Point.of(true));
        assertTrue(Point.of(false) == Point.of(false));
    }
}
