package step03.domain;

import exception.OutOfNameLengthException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import step03.NamesOfResult;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class NamesOfResultTest {

    private static Stream<String> provideResultsOfLadderResult() {
        return Stream.of(
                "꽝,5000,꽝,3000"
        );
    }

    @DisplayName("생성자")
    @ParameterizedTest
    @MethodSource("provideResultsOfLadderResult")
    void test_constructor_of(String results) {
        Assertions.assertThat(NamesOfResult.of(results))
                .isEqualTo(NamesOfResult.of(results));
    }

    private static Stream<String> provideInvalidResultsOfLadderResult() {
        return Stream.of(
                "500000,꽝,3000"
        );
    }

    @DisplayName("결과이름이 0-5 자가 아니면 에러 던짐")
    @ParameterizedTest
    @MethodSource("provideInvalidResultsOfLadderResult")
    void test_constructor_ofs(String results) {
        assertThatExceptionOfType(OutOfNameLengthException.class)
                .isThrownBy(() -> NamesOfResult.of(results));
    }

}
