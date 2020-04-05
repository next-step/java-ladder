package ladder;

import ladder.model.LadderHeight;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

@DisplayName("사다리 높이 입력 테스트")
public class LadderHeightTests {

    @DisplayName("사다리 높이 생성 테스트")
    @Test
    public void generateLadderHeightTests() {
        assertThatCode(() -> LadderHeight.newInstance(5)).doesNotThrowAnyException();

        assertThatIllegalArgumentException()
                .isThrownBy(() -> LadderHeight.newInstance(0))
                .withMessageContaining("Ladder height must be greater than zero.");

        assertThatIllegalArgumentException()
                .isThrownBy(() -> LadderHeight.newInstance(-5))
                .withMessageContaining("Ladder height must be greater than zero.");
    }

}
