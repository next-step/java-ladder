package nextstep.ladder.domain.name;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class NameTest {
    @ParameterizedTest
    @NullSource
    @ValueSource(strings={"", "abcdef"})
    public void 이름은_최대5글자이며_그이상은_에러(String name) {
        assertThatIllegalArgumentException().isThrownBy(() ->
            new Name(name)
        );
    }

    @ParameterizedTest
    @ValueSource(strings={"a", "ab", "abc", "abcd", "abcde"})
    public void 이름이_5글자이하이면_정상(String name) {
        assertThat(new Name(name)).isNotNull();
    }
}