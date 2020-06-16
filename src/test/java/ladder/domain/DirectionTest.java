package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;

@DisplayName("Direction 클래스 테스트")
public class DirectionTest {

    @Test
    void create() {
        assertThatCode(() -> new Direction(true, false))
                .doesNotThrowAnyException();
    }
}
