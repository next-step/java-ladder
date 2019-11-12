package ladder.domain.result;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PrizeTest {

    private static Stream<String> getInvalidPrizeValue() {
        return Stream.of(null, "", " ");
    }

    @Test
    void 생성테스트() {
        String rawPrizeValue = "5000";

        Prize prize = new Prize(rawPrizeValue);

        assertThat(prize).isEqualTo(new Prize(rawPrizeValue));
    }

    @ParameterizedTest
    @MethodSource("getInvalidPrizeValue")
    void 올바르지않은_보상값(String invalidPrize) {
        assertThatThrownBy(() -> new Prize(invalidPrize))
                .isInstanceOf(IllegalArgumentException.class);
    }
}