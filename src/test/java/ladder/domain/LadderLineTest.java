package ladder.domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderLineTest {

    @Test
    public void 생성() {
        LadderLine ladderLine = LadderLine.create(5);
        assertThat(ladderLine).isNotNull();
        assertThat(ladderLine.size()).isEqualTo(5);
    }

    @Test
    public void 이동() {
        LadderLine ladderLine = LadderLine.create(5);
        System.out.println(ladderLine.move(0));
    }
}
