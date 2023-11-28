package ladder.domain;

import ladder.domain.exception.LadderException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.ValueSource;

public class NameTest {

    @ParameterizedTest
    @EmptySource
    @ValueSource(strings = {"abcdef"})
    void 이름_길이_초과(String string) {
        Assertions.assertThatExceptionOfType(LadderException.class)
            .isThrownBy(() -> new Name(string))
            .withMessage("사람 이름은 1자 이상 5자 이하 입니다.");

    }
}
