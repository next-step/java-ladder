package nextstep.ladder.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.*;

@DisplayName("컴마 문자열 분리")
class CommaSeparatorTest {
    @Test
    @DisplayName("구분할 문자열로 문자열 분리 생성")
    void instance() {
        assertThatNoException().isThrownBy(() -> CommaSeparator.from("1 2"));
    }

    @ParameterizedTest
    @DisplayName("문자열은 필수")
    @NullAndEmptySource
    void instance_nullOrEmptyArguments_thrownIllegalArgumentException(String string) {
        assertThatIllegalArgumentException().isThrownBy(() -> CommaSeparator.from(string));
    }

    @Test
    @DisplayName("구분자로 문자 나누기")
    void strings() {
        assertThat(CommaSeparator.from("1").strings()).containsExactly("1");
        assertThat(CommaSeparator.from("1,2").strings()).containsExactly("1", "2");
        assertThat(CommaSeparator.from("a,b,c").strings()).containsExactly("a", "b", "c");
    }
}
