package ladder.domain.data;

import ladder.domain.exception.LadderException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class NameTest {

    @ParameterizedTest
    @EmptySource
    @ValueSource(strings = {"abcdef"})
    void 이름_길이_초과(String string) {
        assertThatExceptionOfType(LadderException.class)
            .isThrownBy(() -> new Name(string))
            .withMessage("사람 이름은 1자 이상 5자 이하 입니다.");

    }

    @Test
    void formatted() {
        assertThat(new Name("a").formatted()).isEqualTo("     a");
    }
}
