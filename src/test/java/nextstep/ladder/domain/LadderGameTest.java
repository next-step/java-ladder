package nextstep.ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LadderGameTest {
    Members members;
    Rewards rewards;
    LadderGame ladderGame;

    @BeforeEach
    private void before() {
        members = Members.from("pobi,mouse,sharp");
        rewards = Rewards.from("1000,꽝,3000");
        ladderGame = new LadderGame(members, new Layer(2));
    }

    @Test
    void 사다리_생성_확인() {
        Ladder ladder = ladderGame.create(() -> true);
        Ladder targetLadder = new Ladder(Arrays.asList(
                Line.createWithVariables(false, true, false),
                Line.createWithVariables(false, true, false)
        ));
        assertThat(ladder).isEqualTo(targetLadder);
    }

    @Test
    void 사다리_결과_확인() {
        Ladder ladder = ladderGame.create(() -> true);
        LadderResults targetResults = new LadderResults(Arrays.asList(
            new LadderResult(new Member("pobi"), new Reward("1000")),
            new LadderResult(new Member("mouse"), new Reward("꽝")),
            new LadderResult(new Member("sharp"), new Reward("3000"))
        ));
        assertThat(ladderGame.start(ladder, rewards)).isEqualTo(targetResults);
    }
}
