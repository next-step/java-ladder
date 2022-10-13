package step4;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import step4.domain.Prize;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.BDDAssertions.then;

class PrizeTest {

    @Test
    @DisplayName("문자열 리스트로 받아 생성")
    void from() {
        then(Prize.from(List.of("1", "2"))).isEqualTo(List.of(new Prize("1"), new Prize("2")));
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("빈 문자열로 생성시 에러")
    void validatePrize(String prize) {
        assertThatIllegalArgumentException().isThrownBy(() -> new Prize(prize));
    }
}