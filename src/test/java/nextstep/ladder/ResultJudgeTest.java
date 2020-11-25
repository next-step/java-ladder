package nextstep.ladder;

import nextstep.ladder.domain.ExecutionsResults;
import nextstep.ladder.domain.Height;
import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Participants;
import nextstep.ladder.mock.MockInputView;
import nextstep.ladder.mock.MockPointsGenerator;
import nextstep.ladder.util.pointsgenerator.PointsGenerator;
import nextstep.ladder.view.InputView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class ResultJudgeTest {
    private InputView mockInputView;
    private PointsGenerator mockPointsGenerator;

    @BeforeEach
    void init() {
        mockInputView = new MockInputView();
        mockPointsGenerator = new MockPointsGenerator();
    }

    @Test
    void resultJudgeTest() {
        //given
        Participants participants = Participants.from(mockInputView.getParticipantNames());
        Height height = Height.valueOf(mockInputView.getHeight());
        Ladder ladder = Ladder.of(participants, height, mockPointsGenerator);
        ExecutionsResults executionResults = ExecutionsResults.of("꽝", "5000", "꽝", "3000");

        //when
        Map<String, String> results = ladder.resultOf(participants, executionResults);

        //then
        assertAll(
                () -> assertThat(results.get("pobi")).isEqualTo("꽝"),
                () -> assertThat(results.get("honux")).isEqualTo("3000"),
                () -> assertThat(results.get("crong")).isEqualTo("꽝"),
                () -> assertThat(results.get("jk")).isEqualTo("5000")
        );
    }
}
