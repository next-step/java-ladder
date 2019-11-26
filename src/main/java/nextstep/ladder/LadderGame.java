package nextstep.ladder;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.LadderResult;
import nextstep.ladder.domain.Participant;
import nextstep.ladder.view.LadderInputView;
import nextstep.ladder.view.LadderResultView;

import java.util.List;

/**
 * @author : 김윤호
 * @version : 1.0
 * @date : 2019-11-11 19:40
 */
public class LadderGame {
    public static void main(String[] args) {
        Participant participants = new Participant(LadderInputView.inputNames());
        List<String> executeResult = LadderInputView.inputExecuteResult(participants.numberOfParticipants());
        Ladder ladder = new Ladder(participants.numberOfParticipants(), LadderInputView.inputLadderHeight());
        LadderResultView.showList(participants.getParticipant());
        LadderResultView.showLadder(ladder.showLadder());
        LadderResultView.showList(executeResult);

        LadderResult ladderResult = new LadderResult(ladder, participants.getParticipant(), executeResult);

        while (true) {
            String input = LadderInputView.inputSeeResult(participants.getParticipant());
            LadderResultView.showLadderResult(ladderResult.findResultByName(input));

            if (input.equals("all")) {
                break;
            }
        }

    }
}
