package nextstep.ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LadderResultsTest {
    LadderResults ladderResults;
    List<LadderResult> results;

    @BeforeEach
    private void before() {
        results = Arrays.asList(
                new LadderResult(new Member("pobi"), new Reward("5000")),
                new LadderResult(new Member("mouse"), new Reward("꽝")),
                new LadderResult(new Member("kiti"), new Reward("10000"))
        );
        Members members = Members.from("pobi,mouse,kiti");
        Rewards rewards = Rewards.from("5000,꽝,10000");
        Ladder ladder = Ladder.of(members, new LadderLayer(2), () -> true);

        ladderResults = LadderResults.of(members, rewards, ladder);
    }

    @Test
    void 단일_결과_확인() {
        assertThat(ladderResults.getResult("pobi")).isEqualTo("5000");
    }

    @Test
    void 전체_결과_확인() {
        assertThat(ladderResults.getResults()).isEqualTo(results);
    }
}