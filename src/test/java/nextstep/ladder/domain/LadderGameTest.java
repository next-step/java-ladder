package nextstep.ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;

public class LadderGameTest {

    private LadderGame ladderGame;

    @BeforeEach
    void setUp() {
        /*
         p0    p1    p2
          |-----|     |
          |     |-----|
          |-----|     |
         r0    r1    r2
         */
        GameEntities gameEntities = GameEntities.from(
                List.of("p0", "p1", "p2"),
                List.of("r0", "r1", "r2")
        );

        Ladder ladder = new Ladder(3, 3, List.of(
                new Line(List.of(true, false)),
                new Line(List.of(false, true)),
                new Line(List.of(true, false))
        ));

        ladderGame = new LadderGame(gameEntities, ladder);
    }

    @Test
    void 참가자이름으로_보상찾기() {
        assertThat(ladderGame.findRewardByParticipantName("p0")).isEqualTo(new Reward("r2"));
        assertThat(ladderGame.findRewardByParticipantName("p1")).isEqualTo(new Reward("r1"));
        assertThat(ladderGame.findRewardByParticipantName("p2")).isEqualTo(new Reward("r0"));
    }

    @Test
    void 모든_결과_찾기() {
        assertThat(ladderGame.findAllResult()).isEqualTo(new LadderGameResults(
                List.of(
                        new LadderGameResult(
                                new Participant("p0"), new Reward("r2")
                        ),
                        new LadderGameResult(
                                new Participant("p1"), new Reward("r1")
                        ),
                        new LadderGameResult(
                                new Participant("p2"), new Reward("r0")
                        )
                )
        ));
    }
}
