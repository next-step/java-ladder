package nextstep.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class PointTest {

    @ParameterizedTest
    @ValueSource(booleans = {true, false})
    @DisplayName("생성자 정상 작동")
    void create(boolean connection) {
        assertNotNull(new Point(connection));
    }
}
