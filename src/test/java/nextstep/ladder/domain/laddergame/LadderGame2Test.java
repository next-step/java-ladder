package nextstep.ladder.domain.laddergame;

import nextstep.ladder.domain.ladder.LadderTest;
import nextstep.ladder.domain.laddergame.position.ResultPosition;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class LadderGame2Test {

    @Test
    void play() {
        ResultPosition resultPosition = new LadderGame2().play(LadderTest.getLadder());

        Assertions.assertThat(resultPosition.getFinishPosition(0)).isEqualTo(2);
        Assertions.assertThat(resultPosition.getFinishPosition(1)).isEqualTo(1);
        Assertions.assertThat(resultPosition.getFinishPosition(2)).isEqualTo(3);
        Assertions.assertThat(resultPosition.getFinishPosition(3)).isEqualTo(0);
    }
}