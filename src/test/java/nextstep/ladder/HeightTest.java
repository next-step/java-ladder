package nextstep.ladder;

import nextstep.ladder.domain.Height;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

public class HeightTest {
    @ParameterizedTest
    @ValueSource(ints = {-1, 0})
    @DisplayName("높이가 1보다 작은 경우 throw Exception")
    void heightTestFailureCase(int invalidHeight) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> Height.valueOf(invalidHeight));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 10, 100})
    @DisplayName("높이는 1보다 커야한다.")
    void heightTestSuccessCase(int validHeight) {
        assertThatCode(() -> Height.valueOf(validHeight))
                .doesNotThrowAnyException();
    }
}
