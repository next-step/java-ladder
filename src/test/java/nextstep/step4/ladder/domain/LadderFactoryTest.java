package nextstep.step4.ladder.domain;

import nextstep.step3.ladder.domain.*;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * author       : gwonbyeong-yun <sksggg123>
 * ------------------------------------------
 * | email        : sksggg123               |
 * | github       : github.com/sksggg123    |
 * | blog         : sksggg123.github.io     |
 * ------------------------------------------
 * project      : java-ladder
 * create date  : 2019-07-05 13:57
 */
class LadderFactoryTest {

    @Test
    void play() {
        Ladder ladder = new Ladder(
                Arrays.asList(
                        new LadderLine(
                                Arrays.asList(
                                        new Link(0, new Point(true, false)),
                                        new Link(1, new Point(false, true)),
                                        new Link(2, new Point(false, false)))),
                        new LadderLine(
                                Arrays.asList(
                                        new Link(0, new Point(false, false)),
                                        new Link(1, new Point(true, false)),
                                        new Link(2, new Point(false, true))))));

        assertThat(LadderFactory.play(ladder, 3).get(0)).isEqualTo(2);
    }
}