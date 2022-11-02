package step3.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {
    @Test
    void 사다리가_사람수에_맞게_생성되는지() {
        Ladder ladder = new Ladder(5,4);
        assertThat(ladder.lines.size()).isEqualTo(5);
        assertThat(ladder.lines.get(0).hasLine.size()).isEqualTo(3);
    }
}
