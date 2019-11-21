package ladder;

import ladder.domain.Ladder;
import ladder.domain.Participants;
import ladder.domain.Results;
import ladder.service.LadderService;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderServiceTest {
    Participants participants = new Participants("pobi,honux,crong,jk");
    Results results = new Results("꽝,5000,꽝,3000");

    int height = 5;
    Ladder ladder = new Ladder(height, participants.countOfParticipants());

    @Test
    void 한명_이동_결과() {
        int movedPosition = LadderService.moveResultPosition(participants, ladder, "pobi");
        assertThat(movedPosition).isIn(0, 1, 2, 3);
    }

    @Test
    void ALL_이동_결과() {
        Map<String, String> allResults = LadderService.moveAllResultsPosition(participants, ladder, results);
        assertThat(allResults).hasSize(4);
    }
}
