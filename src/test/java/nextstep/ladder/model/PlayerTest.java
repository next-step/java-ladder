package nextstep.ladder.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class PlayerTest {

    @Test
    @DisplayName("사람 이름 5글자 초과시 IllegalArgumentException 발생 테스트")
    void nameMaxLengthOverTest() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Player("abcdef"));
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("사람 이름이 null 이거나 빈 값일 경우 IllegalArgumentException 발생 테스트")
    void nameIsNull(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> new Player(input));
    }

}