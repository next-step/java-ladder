package ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LadderGameTest {
    @Test
    void 사다리_게임_생성_테스트() {
        LadderGame ladderGame = new LadderGame(
                new Participants(List.of(new Participant("aa"), new Participant("bb"))),
                new Rewards(List.of(new Reward("상금1"), new Reward("상금2"))),
                Ladder.of(1, new Participants(List.of(new Participant("aa"), new Participant("bb"))), always -> true)
        );
        Results results = ladderGame.play();

        assertThat(results.printTarget("aa")).isEqualTo("상금2");
        assertThat(results.printTarget("bb")).isEqualTo("상금1");
    }
}