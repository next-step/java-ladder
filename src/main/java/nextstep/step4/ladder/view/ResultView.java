package nextstep.step4.ladder.view;

import nextstep.step4.ladder.domain.Ladder;
import nextstep.step4.ladder.domain.Participant;
import nextstep.step4.ladder.domain.PlayResult;
import nextstep.step4.ladder.domain.PrizeInfo;

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

    void printResultInfo(PlayResult result, String name);
}
