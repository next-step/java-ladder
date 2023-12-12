package nextstep.ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LadderTest {
    @Test
    void lines_생성() {
        Ladder ladder = LadderFactory.createLadder(List.of("a", "b", "c", "d", "e"), 5, List.of("꽝","꽝","꽝","꽝","꽝"));
        assertThat(ladder.getLines().size()).isEqualTo(5);
    }

    @Test
    void 사다리_진행() {
        Ladder ladder = LadderFactory.createLadder(List.of("a", "b", "c", "d", "e"), 5, List.of("꽝","꽝","꽝","꽝","꽝"));
        ladder.run();
        assertThat(ladder.getGameResultPerPlayer("a")).isEqualTo("꽝");
    }
}