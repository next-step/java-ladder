package ladder.domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderLadderLadderLineTest {

    @Test
    public void 생성() {
        LadderLine ladderLine = LadderLine.create(5);
        assertThat(ladderLine).isNotNull();
        assertThat(ladderLine.size()).isEqualTo(5);
    }

    @Test
    public void 연결() {
        LadderLine ladderLine = LadderLine.create(5);
//        Point point = ladderLine.draw(1);
//        assertThat(point.isConnected()).isTrue();

    }

    @Test
    public void 연결_불가() {
        LadderLine ladderLine = LadderLine.create(5);
//        Point point = ladderLine.draw(4);
//        assertThat(point.isConnected()).isFalse();
    }
}
