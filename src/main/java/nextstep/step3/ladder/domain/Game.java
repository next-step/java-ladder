package nextstep.step3.ladder.domain;

import nextstep.step3.ladder.dto.Result;
import nextstep.step3.ladder.util.ConvertUtil;

import java.util.stream.Collectors;

/**
 * author       : gwonbyeong-yun <sksggg123>
 * ------------------------------------------
 * | email        : sksggg123               |
 * | github       : github.com/sksggg123    |
 * | blog         : sksggg123.github.io     |
 * ------------------------------------------
 * project      : java-ladder
 * create date  : 2019-07-01 23:38
 */
public class Game {
    private final Participant participant;
    private final PrizeInfo prizeInfo;

    public Game(PrizeInfo prizeInfo, Participant participant) {
        this.prizeInfo = prizeInfo;
        this.participant = participant;
    }

    public Result execute(Ladder ladder) {
        PrizeInfo resultInfo = PrizeInfo.of(participant.stream()
                .map(participantName -> run(ladder, participantName))
                .collect(Collectors.toList()), participant.count());

        return new Result(ConvertUtil.convertToMap(participant, resultInfo));
    }

    private Prize run(Ladder ladder, Name name) {
        int participantNumber = participant.getParticipantNumber(name);
        int prizeSearchIndex = ladder.startMove(participantNumber);
        return prizeInfo.getPrizeByIndex(prizeSearchIndex);
    }
}