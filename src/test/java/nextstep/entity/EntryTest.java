package nextstep.entity;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.BDDAssertions.then;

class EntryTest {

    private static Stream<Arguments> provideArguments() {
        return Stream.of(
                Arguments.of(""),
                Arguments.of("123456")
        );
    }

    @ParameterizedTest
    @DisplayName("생성자 유효성 에러 처리 확인")
    @MethodSource("provideArguments")
    void validateNegative(String name) {
        assertThatThrownBy(() -> Entry.of(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름은 최소 1 글자, 최대 5 글자 까지 부여할 수 있어요.");
    }

    @Test
    @DisplayName("팩토리 메소드 검증")
    void of() {
        String name = "pobi";
        String expected = "pobi";
        then(Entry.of(name)).isEqualTo(Entry.of(expected));
    }
}
