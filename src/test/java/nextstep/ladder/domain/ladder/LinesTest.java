package nextstep.ladder.domain.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;

public class LinesTest {

    @Test
    @DisplayName("lines 클래스 생성 테스트")
    void create() {
        assertThatCode(() -> new Lines(Height.from(5), 3, new DirectionRandomPredicate()))
                .doesNotThrowAnyException();
    }
}
