package nextstep.ladder.service;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.LadderInfo;
import nextstep.ladder.domain.Participants;
import nextstep.ladder.domain.ResultInfo;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

public class LadderGameHandler {

    private LadderGameHandler() { // 인스턴스화 방지
    }

    public static void runGame() {
        Participants participants = inputAndRegisterParticipant();
        ResultInfo resultInfo = inputGameResultInfo();
        Ladder ladder = drawLadder(participants);

        printLadder(participants, ladder, resultInfo);
    }

    private static ResultInfo inputGameResultInfo() {
        String gameResults = InputView.inputGameResult();
        ResultView.enter();
        return new ResultInfo(gameResults);
    }

    private static void printLadder(Participants participants, Ladder ladder, ResultInfo resultInfo) {
        ResultView.printResultWord();
        ResultView.printParticipantsName(participants);
        ResultView.printLadder(ladder);
        ResultView.printResultInfo(resultInfo);
    }

    private static Ladder drawLadder(Participants participants) {
        int ladderHeight = InputView.inputLadderHeight();
        LadderInfo ladderInfo = new LadderInfo(ladderHeight, participants.count());
        Ladder ladder = Ladder.generate(ladderInfo);
        ResultView.enter();
        return ladder;
    }

    private static Participants inputAndRegisterParticipant() {
        String inputParticipantName = InputView.inputParticipantName();
        ResultView.enter();
        return new Participants(inputParticipantName);
    }
}
