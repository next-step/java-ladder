package ladder.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

@DisplayName("사다리 높이 입력 테스트")
public class LadderHeightTest {

    @DisplayName("사다리 높이 생성 테스트")
    @Test
    public void createLadderHeightTests() {
        assertThatCode(() -> LadderHeight.create(5)).doesNotThrowAnyException();

        assertThatIllegalArgumentException()
            .isThrownBy(() -> LadderHeight.create(0))
            .withMessageContaining("사다리의 높이는 최소 1 이상 입니다.");

        assertThatIllegalArgumentException()
            .isThrownBy(() -> LadderHeight.create(-5))
            .withMessageContaining("사다리의 높이는 최소 1 이상 입니다.");
    }

}