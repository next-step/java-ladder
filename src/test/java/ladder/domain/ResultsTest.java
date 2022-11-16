package ladder.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ResultsTest {
    @DisplayName("결과 갯수가 1개 이상이고 사용자의 수와 일치한다면 결과 객체를 생성할 수 있다.")
    @ParameterizedTest
    @MethodSource("resultSet")
    void constructor(List<String> result) {
        assertThat(new Results(result.size(), result)).isNotNull();
    }

    @DisplayName("결과 갯수가 사용자 수와 일치하지 않거나 결과가 없다면 IllegalArgumentException 예외를 발생시킨다.")
    @ParameterizedTest
    @MethodSource("invalidResultSet")
    void constructor_when_invalid_result(int countOfPerson, List<String> result) {
        assertThatThrownBy(() -> new Results(countOfPerson, result)).isInstanceOf(IllegalArgumentException.class)
                                                                    .hasMessage("The number of results must be greater than 1 and equal to the number of users. countOfPerson="+countOfPerson+", result="+result.size());
    }

    private static Stream<Arguments> resultSet() {
        return Stream.of(
                Arguments.arguments(List.of("3000", "1000", "꽝")),
                Arguments.arguments(List.of("꽝"))
        );
    }

    private static Stream<Arguments> invalidResultSet() {
        return Stream.of(
                Arguments.arguments(2, List.of("3000", "1000", "꽝")),
                Arguments.arguments(0, List.of())
        );
    }
}
