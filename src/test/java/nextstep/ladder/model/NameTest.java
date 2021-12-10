package nextstep.ladder.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class NameTest {

    @Test
    @DisplayName("사람 이름 5글자 초과시 IllegalArgumentException 발생 테스트")
    void name() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Name("abcdef"));
    }
}