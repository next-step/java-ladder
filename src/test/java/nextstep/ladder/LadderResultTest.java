package nextstep.ladder;

import nextstep.ladder.domain.LadderResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LadderResultTest {

    private int validLength = 5;
    private List<String> validResult = List.of("1", "2", "3", "4", "5");

    @Test
    @DisplayName("사다리 결과 생성")
    void testValidLadderResult() {
        LadderResult ladderResult = new LadderResult(validResult, validLength);
        assertThat(ladderResult.getResults()).hasSize(validLength).containsExactlyElementsOf(validResult);
    }

    @ParameterizedTest
    @EmptySource
    @DisplayName("비어있는 결과 올 경우 예외 발생")
    void testEmptyList(List<String> emptyResult) {
        assertThatIllegalArgumentException().isThrownBy(() -> new LadderResult(emptyResult, validLength));
    }

    @ParameterizedTest
    @MethodSource("makeInvalidResult")
    @DisplayName("비어있는 결과가 있거나 개수가 맞지 않는 경우 예외 발생")
    void testInvalidElementTest(List<String> invalidResult) {
        assertThatIllegalArgumentException().isThrownBy(() -> new LadderResult(invalidResult, validLength));

    }

    private static Stream<List<String>> makeInvalidResult() {
        return Stream.of(
                List.of("1", "2", "3"),
                List.of("1", "2", "3", "4", "")
        );
    }
}
