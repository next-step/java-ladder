package ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class LadderRewardTest {

    @DisplayName("꽝 또는 숫자금액이 아니라면, 예외를 발생합니다.")
    @Test
    public void testIfNotMissOrPriceThenInvokeException() {
        assertThatIllegalArgumentException().isThrownBy(() -> LadderReward.of("오천원"));
        assertThatIllegalArgumentException().isThrownBy(() -> LadderReward.of(null));
    }

    @DisplayName("문자열이 꽝 또는 숫자 금액인지 검증 한 후 문자열을 리턴합니다.")
    @ParameterizedTest
    @ValueSource(strings= {"꽝", "1000", "5000"})
    public void testIfMissOrPriceThenValueIsValid(String textOfResult) {
        LadderReward ladderReward = LadderReward.of(textOfResult);
        assertThat(ladderReward.getText()).isEqualTo(textOfResult);
    }
}
