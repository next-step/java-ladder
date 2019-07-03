package nextstep.step3.ladder.view;

import nextstep.step3.ladder.domain.Ladder;
import nextstep.step3.ladder.domain.Participant;
import nextstep.step3.ladder.domain.PrizeInfo;
import nextstep.step3.ladder.dto.Result;

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
    void printParticipant(Participant participant);

    void printLadder(Ladder ladder);

    void printPrizeInfo(PrizeInfo prizeInfo);

    void printResultInfo(Result resut, String name);
}
