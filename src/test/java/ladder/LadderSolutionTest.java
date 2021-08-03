package ladder;

import ladder.view.DosResultView;
import ladder.view.FakeInputView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThatCode;

class LadderSolutionTest {
    @CsvSource(value = {
            "A ,B,C ,D,E,F|5|10",
            "A,B ,C,D,E|5|10",
            "A, B,C, D|5|10",
            "A ,B,C ,D,E,F,G,PP,QQ,QWRA,AA,BB|5|10"
    }, delimiter = '|')
    @DisplayName("통합 테스트")
    @ParameterizedTest
    void run(String playerNames, int lineHeight) {
        assertThatCode(() ->
            new LadderSolution(
                    new FakeInputView(playerNames, lineHeight),
                    new DosResultView()
            ).run()
        ).doesNotThrowAnyException();
    }
}