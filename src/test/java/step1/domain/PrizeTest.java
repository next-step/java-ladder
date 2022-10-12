package step1.domain;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.BDDAssertions.then;

class PrizeTest {

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("비어있는 문자열로 Prize 생성 시 에러 발생")
    void validatePrize(String prize) {
        assertThatIllegalArgumentException().isThrownBy(() -> new Prize(prize));
    }

    @Test
    @DisplayName("문자열 리스트로 입력 받아 생성 시 정상적으로 생성되는지 테스트")
    void construct() {
        then(Prize.from(List.of("1", "2"))).isEqualTo(List.of(new Prize("1"), new Prize("2")));
    }
}