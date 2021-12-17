package ladder.domain.result;

import ladder.domain.ladder.Ladder;
import ladder.domain.ladder.LadderComponent;
import ladder.domain.user.LadderPlayers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ExecutionResultTest {

    @Test
    @DisplayName("ExecutionResults 객체 생성")
    void create() {
        ExecutionResults result = new ExecutionResults(Arrays.asList("꽝", "5000"));
        assertThat(result).isEqualTo(new ExecutionResults(Arrays.asList("꽝", "5000")));
    }

    @ParameterizedTest()
    @ValueSource(ints = {0, 1})
    @DisplayName("index 입력받아 리스트 값 출력")
    void create1(int index) {
        ExecutionResults result = new ExecutionResults(Arrays.asList("꽝", "5000"));
        String results = result.getResults().get(index);
        assertThat(results).isEqualTo(result.getResults().get(index));
    }

    @Test
    @DisplayName("ExecutionResults 값이 비어있을 경우 예외 반환 -> IllegalArgumentException")
    void checkSize() {
        assertThatThrownBy(() -> new ExecutionResults(Collections.EMPTY_LIST))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @MethodSource("provideIndexValue")
    @DisplayName("사다리 게힘 실행 시, 모든 결과항목 반환 - 이름 순서로 결과에 맞는 항목들 ExecutionResults 로 반환")
    void createAllResults(int index, String expectedItem) {
        LadderPlayers players = new LadderPlayers(Arrays.asList("pobi", "honux", "crong"));
        Ladder ladder = Ladder.createLadder(() -> true, LadderComponent.of(3, 3));
        ExecutionResults items = new ExecutionResults(Arrays.asList("꽝", "5000", "10000"));

        ExecutionResults results = items.executeGame(players, ladder);
        assertThat(results.getResults()).size().isEqualTo(3);
        assertThat(results.getResults().get(index)).isEqualTo(expectedItem);
    }

    private static Stream<Arguments> provideIndexValue() {
        return Stream.of(
                Arguments.of(0, "5000"),
                Arguments.of(1, "꽝"),
                Arguments.of(2, "10000")
        );
    }

}