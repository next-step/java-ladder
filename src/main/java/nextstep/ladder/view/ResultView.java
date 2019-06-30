package nextstep.ladder.view;

import nextstep.ladder.domain.Custom;
import nextstep.ladder.domain.Ladder;

/**
 * author       : gwonbyeong-yun <sksggg123>
 * ------------------------------------------
 * | email        : sksggg123               |
 * | github       : github.com/sksggg123    |
 * | blog         : sksggg123.github.io     |
 * ------------------------------------------
 * project      : java-ladder
 * create date  : 2019-06-30 02:49
 */
public interface ResultView {
    void printCustoms(Custom custom);

    void printLadder(Ladder ladder);
}
