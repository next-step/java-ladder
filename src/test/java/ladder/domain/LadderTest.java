package ladder.domain;

import ladder.utils.LadderUtils;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LadderTest {

    @Test
    public void Ladder_생성() {
        Ladder ladder = Ladder.of(4, 5);
        assertThat(ladder.getLines().size()).isEqualTo(5);
    }

    @Test
    public void 사다리_결과_인덱스() {
        Ladder ladder = LadderUtils.createLadder();
        assertAll(
                () -> assertThat(ladder.getLadderEndIdx(0)).isEqualTo(2),
                () -> assertThat(ladder.getLadderEndIdx(1)).isEqualTo(3),
                () -> assertThat(ladder.getLadderEndIdx(2)).isEqualTo(0),
                () -> assertThat(ladder.getLadderEndIdx(3)).isEqualTo(1));
    }

    @Test
    public void 사다리_결과_테스트2() {
        Ladder ladder = LadderUtils.createLadder2();
        assertAll(
                () -> assertThat(ladder.getLadderEndIdx(0)).isEqualTo(2),
                () -> assertThat(ladder.getLadderEndIdx(1)).isEqualTo(1),
                () -> assertThat(ladder.getLadderEndIdx(2)).isEqualTo(0),
                () -> assertThat(ladder.getLadderEndIdx(3)).isEqualTo(3));
    }
}