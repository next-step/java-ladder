package step4.ladderGame.domain.award;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

@SuppressWarnings("NonAsciiCharacters")
class AwardTest {

    @DisplayName("생성")
    @Test
    void create() {
        assertThat(new Award("fail", 5)).isInstanceOf(Award.class);
    }

    @DisplayName("결과가 null이거나 없을 경우 에러발생")
    @ParameterizedTest
    @NullAndEmptySource
    void validate_결과가_null이거나_없을_경우_에러(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Award(input, 5);
        }).withMessageMatching("입력값이 없습니다.");
    }

    @DisplayName("인덱스가 0 미만일 경우 에러발생")
    @ParameterizedTest
    @ValueSource(ints = {-5, -50})
    void validate_인덱스가_0_미만일_경우_에러(int input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Award("10,000", input);
        }).withMessageMatching("index는 0이상이어야 합니다.");
    }

}
