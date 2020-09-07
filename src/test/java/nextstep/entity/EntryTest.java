package nextstep.entity;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class EntryTest {

    private static Stream<Arguments> provideArguments() {
        return Stream.of(
                Arguments.of(""),
                Arguments.of("123456")
        );
    }

    @ParameterizedTest
    @DisplayName("생성자 유효성 처리 확인")
    @MethodSource("provideArguments")
    void validate(String name) {
        assertThatThrownBy(() -> new Entry(name))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
