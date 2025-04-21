package ladder.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class ResultTest {
    @ParameterizedTest
    @DisplayName("결과는 1글자 이상에서 최대 5글자까지 부여할 수 있다")
    @ValueSource(strings = {"a", "ab", "abc", "abcd", "abcde"})
    void resultValueTest(String value) {
        Result result = new Result(value);

        Assertions.assertThat(result.value()).isEqualTo(value);
    }

    @ParameterizedTest
    @DisplayName("결과값은 공백이거나 5글자를 초과하는 경우 에러를 던진다")
    @MethodSource("provideInvalidNames")
    void resultValueThrowTest(String value) {
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> new Result(value))
                .withMessageContaining("결과는 공백이거나 5글자를 초과할 수 없습니다.");
    }

    static Stream<String> provideInvalidNames() {
        return Stream.of(null, "", " ", "abcdef");
    }
}