package nextstep.step2.vo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class GiftTest {
    @DisplayName("당첨 선물은 널이나 빈 값이 올 수 없다.")
    @ParameterizedTest
    @NullAndEmptySource
    void nullOrEmptyTest(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> Gift.from(input));
    }

    @DisplayName("정상 생성 테스트")
    @Test
    void createTest() {
        assertThat(Gift.from("5000")).isEqualTo(Gift.from("5000"));
    }

}
