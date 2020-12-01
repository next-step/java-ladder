package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SpokeTest {

    @DisplayName("발판은 갯수로 생성할 수 있다.")
    @Test
    void createSpokeFromCount() {
        assertThat(Spoke.fromCount(3, createTestingObject(true, false, true))).isNotNull();
    }

    @DisplayName("제네레이터을 통해 생성한 값을 테스트한다")
    @Test
    void spokeCreateFromGenerator() {
        assertThat(Spoke.fromCount(3, createTestingObject(true, false, true)))
                .isEqualTo(Spoke.of(true, false, true));
    }

    private TestingBooleanGenerator createTestingObject(Boolean... booleans) {
        return new TestingBooleanGenerator(booleans);
    }
}
