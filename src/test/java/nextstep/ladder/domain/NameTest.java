package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.junit.jupiter.api.Assertions.assertThrows;

class NameTest {

    @ParameterizedTest(name = "이름은 \"{0}\" 을 가질 수 없다")
    @NullAndEmptySource
    void newName1(String input) {
        assertThrows(IllegalArgumentException.class, () -> new Name(input));
    }

    @Test
    @DisplayName("이름을 생성은 5자를 초과 할 수 없다")
    void newName2() {
        assertThrows(IllegalArgumentException.class, () -> new Name("sixsix"));
    }
}
