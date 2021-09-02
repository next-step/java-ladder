package ladderrefactoring.domain.data;

import ladderrefactoring.exception.CustomException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ResultTest {

    @Test
    @DisplayName("Result 생성")
    void create() {
        // given
        String name = "3000";

        // when
        Result result = new Result(name);

        // then
        assertThat(result).isEqualTo(new Result(name));
    }

    @ParameterizedTest(name = "Result 생성 실패 empty string")
    @ValueSource(strings = {"", "  "})
    void create_fail_empty_string(String name) {
        // when, then
        assertThatThrownBy(() -> new Result(name))
                .isInstanceOf(CustomException.class)
                .hasMessageContaining(Result.EMPTY_STRING_EXCEPTION_MESSAGE);
    }

    @Test
    @DisplayName("Result 생성 실패 null")
    void create_fail_null() {
        // when, then
        assertThatThrownBy(() -> new Result(null))
                .isInstanceOf(CustomException.class)
                .hasMessageContaining(Result.EMPTY_STRING_EXCEPTION_MESSAGE);
    }

    @Test
    @DisplayName("Result 생성 실패 글자수 초과")
    void create_fail_over_length_of_name() {
        // given
        String name = "abcdef";

        // when, then
        assertThatThrownBy(() -> new Result(name))
                .isInstanceOf(CustomException.class)
                .hasMessageContaining(Result.LENGTH_OF_NAME_EXCEPTION_MESSAGE);
    }
}
