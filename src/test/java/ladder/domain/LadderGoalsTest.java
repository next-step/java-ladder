package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

public class LadderGoalsTest {

    @DisplayName("사다리의 결과가 1개이상인지 테스트")
    @Test
    void testResultMoreThanOne() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new LadderGoals(new HashMap<>()));
    }
}
