package nextstep.ladder;

import nextstep.ladder.domain.ExecutionsResults;
import nextstep.ladder.domain.Height;
import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Participants;
import nextstep.ladder.mock.MockInputView;
import nextstep.ladder.mock.MockPointsGenerator;
import nextstep.ladder.util.ResultJudge;
import nextstep.ladder.util.pointsgenerator.PointsGenerator;
import nextstep.ladder.view.ConsoleResultView;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class ResultJudgeTest {
    @Test
    void resultJudgeTest() {
        InputView inputView = new MockInputView();
        Participants participants = Participants.from(inputView.getParticipantNames());
        Height height = Height.valueOf(inputView.getHeight());
        PointsGenerator pointsGenerator = new MockPointsGenerator();
        Ladder ladder = Ladder.of(participants, height, pointsGenerator);
        ResultView resultView = new ConsoleResultView();
        resultView.printResult(participants, ladder);

        List<String> executionResultInput = Arrays.asList("꽝", "5000", "꽝", "3000");
        ExecutionsResults executionResults = ExecutionsResults.of(executionResultInput);

        Map<String, String> results = ResultJudge.of(ladder, participants, executionResults);
        assertAll(
                () -> assertThat(results.get("pobi")).isEqualTo("꽝"),
                () -> assertThat(results.get("honux")).isEqualTo("3000"),
                () -> assertThat(results.get("crong")).isEqualTo("꽝"),
                () -> assertThat(results.get("jk")).isEqualTo("5000")
        );
    }
}
