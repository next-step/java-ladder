package nextstep.ladder;

import nextstep.ladder.domain.ExecutionResults;
import nextstep.ladder.domain.Height;
import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Participants;
import nextstep.ladder.mock.MockPointsGenerator;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class ResultJudgeTest {
    @Test
    void resultJudgeTest() {
        //given
        Participants participants = Participants.of("pobi", "honux", "crong", "jk");
        Height height = Height.valueOf(5);
        Ladder ladder = Ladder.of(participants, height, new MockPointsGenerator());
        ExecutionResults executionResults = ExecutionResults.of(participants, "꽝", "5000", "꽝", "3000");

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
