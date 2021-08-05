package ladder;

import ladder.view.DosResultView;
import ladder.view.FakeInputView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThatCode;

class LadderSolutionTest {
    @CsvSource(value = {
            "pobi,honux,crong,jk|5|꽝,5000,꽝,3000|pobi,all",
            "A ,B,C ,D,E,F|5|1,2,3,4,5,6|A,B,all",
            "A,B ,C,D,E|5|1,2,3,4,5|A,B,all",
            "A, B,C, D|5|1,2,3,4|A,B,all",
            "A ,B,C ,D,E,F,G,PP,QQ,QWRA,AA,BB|100|1,2,3,4,5,6,7,8,9,10,11,12|A,B,all"
    }, delimiter = '|')
    @DisplayName("통합 테스트")
    @ParameterizedTest
    void run(String playerNames, int lineHeight, String prizeNames, String inputPrizeOwnerNames) {
        List<String> inputPrizeOwnerNameList =
                Arrays.stream(inputPrizeOwnerNames.split(","))
                .collect(Collectors.toList());

        assertThatCode(() ->
            new LadderSolution(
                    new FakeInputView(playerNames, lineHeight, prizeNames, inputPrizeOwnerNameList),
                    new DosResultView()
            ).run()
        ).doesNotThrowAnyException();
    }
}