package nextstep.ladder.domain.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;

public class DirectionPredicateTest {

    @Test
    @DisplayName("랜덤 DirectionPredicate 생성 테스트")
    void create() {
        assertThatCode(() -> new DirectionRandomPredicate()).doesNotThrowAnyException();
    }
}
