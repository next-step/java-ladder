package ladder.domain.result;

import ladder.exception.EmptyResultValueException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("Results Test")
class ResultsTest {

    List<String> resultValues;

    @BeforeEach
    void setUp() {
        resultValues = Arrays.asList("100", "꽝", "200", "하이");
    }

    @Test
    @DisplayName("Results 생성")
    void generate() {
        // given
        // when
        Results actual = Results.of(resultValues);

        // then
        assertThat(actual).isEqualTo(Results.of(resultValues));
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("Results 생성시 null 또는 빈값이 들어올경우 Exception")
    void valuesInEmptyException(String value) {
        // given
        resultValues.set(0, value);

        assertThatThrownBy(() -> Results.of(resultValues))
                .isInstanceOf(EmptyResultValueException.class);
    }
}