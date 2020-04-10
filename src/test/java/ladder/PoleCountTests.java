package ladder;

import ladder.model.PoleCount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

@DisplayName("PoleCount 테스트")
public class PoleCountTests {

    @DisplayName("Pole 카운트 생성 테스트")
    @Test
    public void generateMembersCountTests() {
        assertThatCode(() -> PoleCount.of(3)).doesNotThrowAnyException();
    }

    @DisplayName("Pole 카운트 생성 실패 테스트")
    @Test
    public void generateMembersCountFailTests() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> PoleCount.of(-3))
                .withMessageContaining("Ladder Pole count must be greater than zero.");
    }
}
