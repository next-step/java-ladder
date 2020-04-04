package ladder.domain;

import ladder.exception.InvalidHeightException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class HeightTest {

    @DisplayName("높이 객체를 생성한다.")
    @Test
    void create() {
        String height = "1";
        Height expect = Height.of(height);

        Height actual = Height.of(height);

        assertThat(actual).isEqualTo(expect);
    }

    @DisplayName("높이가 공백이거나 null 값 일 경우 커스텀 예외를 발생한다.")
    @ParameterizedTest
    @MethodSource("invalidHeights")
    void validHeight(String height) {
        assertThatExceptionOfType(InvalidHeightException.class).isThrownBy(
                () ->  Height.of(height)
        );
    }

    static Stream<String> invalidHeights() {
        return Stream.of(" ", "", null);
    }
}