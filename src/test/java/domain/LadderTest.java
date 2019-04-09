package domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {
    @Test
    public void 길이x높이의_사다리를_생성한다() {
        Ladder ladder = new Ladder(3, 5);
        assertThat(ladder.getLines()).hasSize(5);
    }

    @Test
    public void 시작점을_넣으면_마지막점을_반환한다() {
        Ladder ladder1 = new Ladder(3, 5);

        assertThat(ladder1.search(1)).isEqualTo(2);
        assertThat(ladder1.search(2)).isEqualTo(1);
        assertThat(ladder1.search(3)).isEqualTo(3);

        Ladder ladder2 = new Ladder(5, 3);

        assertThat(ladder2.search(1)).isEqualTo(2);
        assertThat(ladder2.search(3)).isEqualTo(4);
    }
}
