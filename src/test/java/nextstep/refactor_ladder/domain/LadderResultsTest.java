package nextstep.refactor_ladder.domain;

import nextstep.refactor_ladder.domain.value.ExecutionResult;
import nextstep.refactor_ladder.domain.value.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class LadderResultsTest {
    private Map<Person, ExecutionResult> ladderResults;

    @BeforeEach
    void setup() {
        ladderResults = new HashMap<>();
        ladderResults.put(Person.from("aiden"), ExecutionResult.from("1000"));
        ladderResults.put(Person.from("pobi"), ExecutionResult.from("2000"));
        ladderResults.put(Person.from("crong"), ExecutionResult.from("꽝"));
    }

    @ParameterizedTest
    @MethodSource(value = "ladderResult")
    @DisplayName("참여한 사람에 대한 최종 결과 확인 검증")
    void create(Person person, ExecutionResult expected) {
        LadderResults results = LadderResults.from(ladderResults);
        assertThat(results.getLadderResult(person)).isEqualTo(expected);
    }

    private static Stream<Arguments> ladderResult() {
        return Stream.of(
                Arguments.of(Person.from("aiden"), ExecutionResult.from("1000")),
                Arguments.of(Person.from("pobi"), ExecutionResult.from("2000")),
                Arguments.of(Person.from("crong"), ExecutionResult.from("꽝"))
        );
    }

}
