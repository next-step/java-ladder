package nextstep.step4.ladder.domain;

import nextstep.step3.ladder.domain.Ladder;
import nextstep.step3.ladder.domain.LadderLine;
import nextstep.step3.ladder.domain.Link;
import nextstep.step3.ladder.domain.Point;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

/**
 * author       : gwonbyeong-yun <sksggg123>
 * ------------------------------------------
 * | email        : sksggg123               |
 * | github       : github.com/sksggg123    |
 * | blog         : sksggg123.github.io     |
 * ------------------------------------------
 * project      : java-ladder
 * create date  : 2019-06-30 04:18
 */
public class LadderTest {
    @DisplayName("사다리 생성시 전달된 인자가 비어있을때")
    @Test
    void createLadderException() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Ladder(Arrays.asList());
        }).withMessageContaining("사다리가 비어있습니다.");
    }

    @DisplayName("시작점으로 부터 마지막 도착 index 가지고 오기")
    @Test
    void executeLadderGame() {
        Ladder ladder = new Ladder(
                Arrays.asList(
                        new LadderLine(
                                Arrays.asList(
                                        new Link(0, new Point(true, false)),
                                        new Link(1, new Point(false, true)))),
                        new LadderLine(
                                Arrays.asList(
                                        new Link(0, new Point(false, false)),
                                        new Link(1, new Point(false, false))))));

        assertThat(ladder.execute(0)).isEqualTo(1);
    }
}
