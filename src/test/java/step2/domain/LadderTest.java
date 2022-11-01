package step2.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {
    @Test
    void 사다리_사이즈가_맞게_생성되었는지_라인수는_사람수_마이너스1() {
        Ladder ladder = new Ladder(5);
        ladder.createLadder(4);
        assertThat(ladder.lines.size()).isEqualTo(5);
        assertThat(ladder.lines.get(0).hasLine.size()).isEqualTo(3);
    }
}
