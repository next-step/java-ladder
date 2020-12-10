package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderGameTest {
    private LadderGame ladderGame;

    @BeforeEach
    void init() {
        Participants participants = Participants.of("a,b,c,d,e");
        Rewards rewards = Rewards.of("1,2,3,4,5");
        HeadAndTail headAndTail = HeadAndTail.init(participants, rewards);
        Ladder ladder = Ladder.init(5, participants.size());
        ladderGame = LadderGame.init(headAndTail, ladder);
    }

    @Test
    void fetchAllResultsTest() {
        Map<String, String> allResults = ladderGame.fetchAllResults();
        assertThat(allResults.get("a")).isBetween("1", "5");
    }
}
