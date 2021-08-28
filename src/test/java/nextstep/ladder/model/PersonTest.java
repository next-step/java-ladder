package nextstep.ladder.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class PersonTest {
    @DisplayName("잘못된 사람이름 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"abcdef", " ", ""})
    public void wrongNameTest(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> new Person(input));
    }
}
