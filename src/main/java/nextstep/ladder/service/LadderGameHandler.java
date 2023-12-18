package nextstep.ladder.service;

import nextstep.ladder.domain.*;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

public class LadderGameHandler {

    private LadderGameHandler() { // 인스턴스화 방지
    }

    public static void runGame() {
        Participants participants = inputAndRegisterParticipant();
        ResultInfo resultInfo = inputGameResultInfo();
        Ladder ladder = drawLadder(participants);

        moveParticipants(participants, ladder);

        printLadder(participants, ladder, resultInfo);
        printResult(participants, resultInfo);
    }

    private static void moveParticipants(Participants participants, Ladder ladder) {
        for (int i = 0; i < ladder.getHeight(); i++) {
            Line lineByHeight = ladder.getLineByHeight(i);
            moveParticipantsOnLadder(participants, lineByHeight);
        }
    }

    private static void moveParticipantsOnLadder(Participants participants, Line line) {
        for (int i = 0; i < participants.count(); i++) {
            if (line.getPointsByIndex(i).getCurrent()) {
                Participant currentParticipant = participants.getParticipantByPosition(i);
                currentParticipant.moveBack();
                Participant previousParticipant = participants.getParticipantByPosition(i - 1);
                previousParticipant.moveFront(participants.count());
            }
        }
    }

    private static void printResult(Participants participants, ResultInfo resultInfo) {
        while (true) {
            String inputName = InputView.inputForParticipantResult();
            if (inputName.trim().equals("all")) {
                ResultView.printResultAll(participants, resultInfo);
                return;
            }
            Participant participant = participants.getParticipantByName(inputName);
            participant.toString();
            ResultView.printResultOfParticipant(resultInfo.getResult(participant.getPosition()));
        }
    }

    private static ResultInfo inputGameResultInfo() {
        String gameResults = InputView.inputGameResult();
        ResultView.enter();
        return new ResultInfo(gameResults);
    }

    private static void printLadder(Participants participants, Ladder ladder, ResultInfo resultInfo) {
        ResultView.printLadderWord();
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
