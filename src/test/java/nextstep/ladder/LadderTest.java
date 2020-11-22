package nextstep.ladder;

import nextstep.ladder.domain.Height;
import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Participants;
import nextstep.ladder.mock.MockInputView;
import nextstep.ladder.mock.MockPointsGenerator;
import nextstep.ladder.util.pointsgenerator.PointsGenerator;
import nextstep.ladder.view.ConsoleResultView;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {
    @Test
    @DisplayName("Ladder-Line의 값은 PointGenerator에서 설정된 boolean값으로 만들어 진다.")
    void ladderTest() {
        InputView inputView = new MockInputView();
        Participants participants = Participants.from(inputView.getParticipantNames());
        Height height = Height.valueOf(inputView.getHeight());
        PointsGenerator pointsGenerator = new MockPointsGenerator();
        Ladder ladder = Ladder.of(participants, height, pointsGenerator);
        ResultView resultView = new ConsoleResultView();
        resultView.printResult(participants, ladder);

        MockPointsGenerator mockPointsGenerator = new MockPointsGenerator();
        ladder.linesForEach(line -> line.pointsForEach(point -> {
            assertThat(point).isEqualTo(mockPointsGenerator.getMockPoint());
        }));
    }
}
