package ladder.model;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("사다리 테스트")
class LadderTest {
    @DisplayName("사다리 생성 테스트")
    @Test
    public void generateLadderTests() {
        assertThatCode(() -> Ladder.create(4, 5)).doesNotThrowAnyException();
    }

    @DisplayName("사다리 생성 - 비정상 테스트")
    @Test
    public void generateLadderAbnormalTests() {
        assertThatIllegalArgumentException().isThrownBy(() -> Ladder.create(0, 0))
            .withMessageContaining("사다리 라인은 하나 이상이어야 합니다.");
    }
}