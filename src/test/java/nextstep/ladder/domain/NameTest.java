package nextstep.ladder.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.junit.jupiter.api.Assertions.assertThrows;

class NameTest {

    @ParameterizedTest(name = "이름은 \"{0}\" 을 가질 수 없다")
    @NullAndEmptySource
    void 이름은_null_혹은_공백을_가질_수_없다(String input) {
        assertThrows(IllegalArgumentException.class, () -> new Name(input));
    }

    @Test
    void 이름을_생성은_5자를_초과_할_수_없다() {
        assertThrows(IllegalArgumentException.class, () -> new Name("sixsix"));
    }
}
