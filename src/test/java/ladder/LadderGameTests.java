package ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

@DisplayName("사다리 테스트")
public class LadderGameTests {

    @DisplayName("사다리 생성 테스트")
    @ParameterizedTest
    @CsvSource(value = {"3,4", "4,5"})
    public void generateLadderTests(final int memberCount, final int ladderHeight) {
        assertThatCode(() -> LadderGame.newInstance(memberCount, ladderHeight));
    }

    @DisplayName("사다리 생성 테스트 - 비정상")
    @ParameterizedTest
    @CsvSource(value = {"-13,0", "0,-5"})
    public void generateLadderTests(final int memberCount, final int ladderHeight) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> LadderGame.newInstance(memberCount, ladderHeight))
                .withMessageContaining("member count and ladder height must be greater than zero.");
    }
}
